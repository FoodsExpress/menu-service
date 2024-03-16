package com.foodexpress.menuservice.application.port.out;

import com.foodexpress.menuservice.domain.MenuOption;

import java.util.List;

public interface RegisterMenuOptionPort {

    List<MenuOption> saveMenuOptions(String menuId, List<MenuOption> menuOptions);

}
