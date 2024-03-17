package com.foodexpress.menuservice.application.service;

import com.foodexpress.menuservice.application.port.in.menu.ModifyMenuCommand;
import com.foodexpress.menuservice.application.port.in.menu.ModifyMenuOptionCommand;
import com.foodexpress.menuservice.application.port.in.menu.ModifyMenuUseCase;
import com.foodexpress.menuservice.application.port.out.ModifyMenuOutPort;
import com.foodexpress.menuservice.common.UseCase;
import com.foodexpress.menuservice.domain.Menu;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ModifyMenuService implements ModifyMenuUseCase {

    private final ModifyMenuOutPort modifyMenuOutPort;

    @Override
    public Menu modifyMenu(ModifyMenuCommand modifyMenuCommand) {
        return modifyMenuOutPort.updateMenu(modifyMenuCommand.mapToDomain());
    }

    @Override
    public MenuOption modifyMenuOption(ModifyMenuOptionCommand modifyMenuOptionCommand) {
        return modifyMenuOutPort.updateMenuOption(modifyMenuOptionCommand.mapToDomain());
    }

}
