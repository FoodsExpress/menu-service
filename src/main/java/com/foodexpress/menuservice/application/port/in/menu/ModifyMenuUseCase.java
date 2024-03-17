package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.domain.Menu;
import com.foodexpress.menuservice.domain.MenuOption;

public interface ModifyMenuUseCase {

    Menu modifyMenu(ModifyMenuCommand modifyMenuCommand);

    MenuOption modifyMenuOption(ModifyMenuOptionCommand modifyMenuOptionCommand);

}
