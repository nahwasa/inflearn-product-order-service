package com.nahwasa.study.inflearnproductorderservice;

import com.google.common.base.CaseFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 테스트 격리를 위한 코드.
 * 예를들어 테스트마다 상품 id를 1부터 시작하도록 하기 위해 사용.
 * https://www.youtube.com/watch?v=ITVpmjM4mUE 44분쯤 참고
 */
@Component
public class DatabaseCleanup implements InitializingBean {
    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    @Override
    public void afterPropertiesSet() {
        final Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities(); // EntityManager에서 JPA Entity를 전부 가져오고
        tableNames = entities.stream()
                .filter(e -> isEntity(e) && hasTableAnnotation(e))  // Entity랑 TABLE 어노테이션 있는지 확인해서 tableNames에 리스트로 전부 담음.
                .map(e -> {
                    String tableName = e.getJavaType().getAnnotation(Table.class).name();
                    return tableName.isBlank() ? CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, e.getName()) : tableName;
                })
                .collect(Collectors.toList());

        final List<String> entityNames = entities.stream()
                .filter(e -> isEntity(e) && !hasTableAnnotation(e)) // entity면서 table이 없는애들을 ProductItem -> product_item처럼 변경
                .map(e -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, e.getName()))
                .toList();

        tableNames.addAll(entityNames);
    }

    private boolean isEntity(final EntityType<?> e) {
        return null != e.getJavaType().getAnnotation(Entity.class);
    }

    private boolean hasTableAnnotation(final EntityType<?> e) {
        return null != e.getJavaType().getAnnotation(Table.class);
    }

    @Transactional
    public void execute() {
        entityManager.flush();
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate(); // 다른 테이블과 연관되어있을때 안지워지는거 무시

        for (final String tableName : tableNames) {
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
            entityManager.createNativeQuery("ALTER TABLE " + tableName + " ALTER COLUMN ID RESTART WITH 1").executeUpdate();
        }

        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }

}
