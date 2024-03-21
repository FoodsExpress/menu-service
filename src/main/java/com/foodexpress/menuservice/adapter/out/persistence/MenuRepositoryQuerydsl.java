package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;

import java.util.List;

public interface MenuRepositoryQuerydsl {

    List<MenuDTO> findAllBySearchCondition(SearchMenuQuery condition, Integer cursor, Integer size);

    List<MenuDTO> findFirstBySearchCondition(SearchMenuQuery command, Integer size);

}
