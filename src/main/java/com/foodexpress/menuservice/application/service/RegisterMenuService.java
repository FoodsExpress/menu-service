package com.foodexpress.menuservice.application.service;

import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuCommand;
import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuUseCase;
import com.foodexpress.menuservice.application.port.out.RegisterMenuPort;
import com.foodexpress.menuservice.common.UseCase;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterMenuService implements RegisterMenuUseCase {

    private final RegisterMenuPort registerMenuPort;

    /**
     * 메뉴 등록
     *
     * @param registerMenuCommand 메뉴 등록 요청 객체
     * @return 등록된 메뉴 정보
     */
    @Override
    public Menu registerMenu(RegisterMenuCommand registerMenuCommand) {
        return registerMenuPort.saveMenu(registerMenuCommand.mapToDomain());
    }

}
