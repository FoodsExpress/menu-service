package com.foodexpress.menuservice.application.port.out;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import com.foodexpress.menuservice.domain.Menu;

import java.util.List;

public interface SearchMenuPort {

    List<Menu> getSearchMenu(SearchMenuQuery command, Integer cursor, Integer size);

    List<Menu> getSearchMenuInit(SearchMenuQuery command, Integer cursor, Integer size);

}
