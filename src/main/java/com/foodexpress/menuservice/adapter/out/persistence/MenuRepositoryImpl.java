package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.foodexpress.menuservice.adapter.out.persistence.QMenuEntity.menuEntity;
import static com.querydsl.core.types.Projections.fields;

public class MenuRepositoryImpl extends Querydsl5Support implements MenuRepositoryQuerydsl {

    protected MenuRepositoryImpl() {
        super(MenuEntity.class);
    }

    @Override
    public List<MenuDTO> findAllBySearchCondition(SearchMenuQuery condition, Integer cursor, Integer size) {
        return select(fields(MenuDTO.class,
                             menuEntity.id,
                             menuEntity.menuId,
                             menuEntity.storeId,
                             menuEntity.menuName,
                             menuEntity.menuDescription,
                             menuEntity.orderNumber,
                             menuEntity.active,
                             menuEntity.createdBy,
                             menuEntity.createdDate,
                             menuEntity.updatedBy,
                             menuEntity.updatedDate)).from(menuEntity).where(menuEntity.id.lt(cursor), searchCondition(condition)).limit(
            size).orderBy(menuEntity.id.desc()).fetch();

    }

    @Override
    public List<MenuDTO> findFirstBySearchCondition(SearchMenuQuery command, Integer size) {
        return select(fields(MenuDTO.class,
                             menuEntity.id,
                             menuEntity.menuId,
                             menuEntity.storeId,
                             menuEntity.menuName,
                             menuEntity.menuDescription,
                             menuEntity.orderNumber,
                             menuEntity.active,
                             menuEntity.createdBy,
                             menuEntity.createdDate,
                             menuEntity.updatedBy,
                             menuEntity.updatedDate)).from(menuEntity).where(searchCondition(command)).limit(
            size).orderBy(menuEntity.id.desc()).fetch();
    }

    private BooleanBuilder searchCondition(SearchMenuQuery condition) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        return booleanBuilder.and(equalsStoreId(condition.getStoreId()))
            .and(equalsMenuId(condition.getMenuId()))
            .and(equalsMenuName(condition.getMenuName()));
    }

    private BooleanExpression equalsMenuName(String menuName) {
        return StringUtils.hasText(menuName) ? menuEntity.menuName.eq(menuName) : null;
    }

    private BooleanExpression equalsMenuId(Long menuId) {
        return menuId != null ? menuEntity.id.eq(menuId) : null;
    }

    private BooleanExpression equalsStoreId(String storeId) {
        return StringUtils.hasText(storeId) ? menuEntity.storeId.eq(storeId) : null;
    }

}
