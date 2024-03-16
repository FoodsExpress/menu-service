package com.foodexpress.menuservice.application.service;

import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuOptionCommand;
import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuOptionUseCase;
import com.foodexpress.menuservice.application.port.out.RegisterMenuOptionPort;
import com.foodexpress.menuservice.common.UseCase;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterMenuOptionService implements RegisterMenuOptionUseCase {

    private final RegisterMenuOptionPort registerMenuOptionPort;

    @Override
    public List<MenuOption> registerMenuOptions(String menuId, List<RegisterMenuOptionCommand> commands) {
        return registerMenuOptionPort.saveMenuOptions(menuId, commands.stream().map(RegisterMenuOptionCommand::mapToDomain).toList());
    }

}
