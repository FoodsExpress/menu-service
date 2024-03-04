package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.domain.Menu;

/**
 * 메뉴 등록 인터페이스
 *
 * @author seunggu.lee
 */
public interface RegisterMenuUseCase {

    Menu registerMenu(RegisterMenuCommand registerMenuCommand);

}
