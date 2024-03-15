package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.domain.MenuOption;

import java.util.List;

public interface RegisterMenuOptionUseCase {

    List<MenuOption> registerMenuOptions(String menuId, List<RegisterMenuOptionCommand> commands);

}
