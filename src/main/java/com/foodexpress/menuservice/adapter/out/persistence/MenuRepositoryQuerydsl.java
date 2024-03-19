package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import com.foodexpress.menuservice.domain.Menu;

import java.util.List;

public interface MenuRepositoryQuerydsl {

    List<Menu> findAllBySearchCondition(SearchMenuQuery condition, Integer cursor, Integer size);

    List<Menu> findFirstBySearchCondition(SearchMenuQuery command, Integer cursor, Integer size);

}
