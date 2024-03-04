package com.foodexpress.menuservice.application.port.in;

import com.foodexpress.menuservice.domain.MenuOption;

public interface RegisterMenuOptionUseCase {

    MenuOption registerMenuOption(RegisterMenuOptionCommand command);

}
