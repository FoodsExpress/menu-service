package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.domain.MenuOption;

public interface RegisterMenuOptionUseCase {

    MenuOption registerMenuOption(RegisterMenuOptionCommand command);

}
