package com.foodexpress.menuservice.application.service;

import com.foodexpress.menuservice.application.port.in.ModifyMenuCommand;
import com.foodexpress.menuservice.application.port.in.ModifyMenuUseCase;
import com.foodexpress.menuservice.application.port.out.ModifyMenuOutPort;
import com.foodexpress.menuservice.common.UseCase;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ModifyMenuService implements ModifyMenuUseCase {

    private final ModifyMenuOutPort modifyMenuOutPort;

    @Override
    public Menu modifyMenu(ModifyMenuCommand modifyMenuCommand) {
        return modifyMenuOutPort.updateMenu(modifyMenuCommand.mapToDomain());
    }

}
