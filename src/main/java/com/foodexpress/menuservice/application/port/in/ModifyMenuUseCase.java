package com.foodexpress.menuservice.application.port.in;

import com.foodexpress.menuservice.domain.Menu;

public interface ModifyMenuUseCase {

    Menu modifyMenu(ModifyMenuCommand modifyMenuCommand);

}
