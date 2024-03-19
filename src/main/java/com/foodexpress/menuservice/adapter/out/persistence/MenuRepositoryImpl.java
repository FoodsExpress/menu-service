package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import com.foodexpress.menuservice.domain.Menu;

import java.util.List;

import static com.foodexpress.menuservice.adapter.out.persistence.QMenuEntity.menuEntity;
import static com.querydsl.core.types.Projections.fields;

public class MenuRepositoryImpl extends Querydsl5Support implements MenuRepositoryQuerydsl {

    protected MenuRepositoryImpl() {
        super(MenuEntity.class);
    }

    @Override
    public List<Menu> findAllBySearchCondition(SearchMenuQuery condition, Integer cursor, Integer size) {
        return select(fields(Menu.class,
                             menuEntity.menuId,
                             menuEntity.storeId,
                             menuEntity.menuName,
                             menuEntity.menuDescription,
                             menuEntity.orderNumber,
                             menuEntity.active,
                             menuEntity.menuOptions,
                             menuEntity.createdBy,
                             menuEntity.createdDate,
                             menuEntity.updatedBy,
                             menuEntity.updatedDate)).from(menuEntity).where(menuEntity.id.goe(cursor)).limit(size).fetch();

    }

    @Override
    public List<Menu> findFirstBySearchCondition(SearchMenuQuery command, Integer size) {
        return select(fields(Menu.class,
                             menuEntity.menuId,
                             menuEntity.storeId,
                             menuEntity.menuName,
                             menuEntity.menuDescription,
                             menuEntity.orderNumber,
                             menuEntity.active,
                             menuEntity.menuOptions,
                             menuEntity.createdBy,
                             menuEntity.createdDate,
                             menuEntity.updatedBy,
                             menuEntity.updatedDate)).from(menuEntity).limit(size).fetch();
    }

}
