package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.domain.Menu;

import java.util.List;

public interface SearchMenuUseCase {

    List<Menu> searchMenu(SearchMenuQuery command, Integer cursor, Integer size);

}
