package com.foodexpress.menuservice.application.port.out;

import com.foodexpress.menuservice.domain.Menu;
import com.foodexpress.menuservice.domain.MenuOption;

public interface ModifyMenuOutPort {

    Menu updateMenu(Menu menu);

    MenuOption updateMenuOption(MenuOption menuOption);

}
