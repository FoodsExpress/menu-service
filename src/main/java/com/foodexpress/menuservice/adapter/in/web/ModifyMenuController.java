package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.application.port.in.menu.ModifyMenuUseCase;
import com.foodexpress.menuservice.common.ApiUtil;
import com.foodexpress.menuservice.domain.Menu;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.foodexpress.menuservice.common.ApiUtil.success;

/**
 * 메뉴 수정 컨트롤러
 *
 * @author yeji.cho
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class ModifyMenuController {

    private final ModifyMenuUseCase modifyMenuUseCase;

    /**
     * 메뉴 수정
     *
     * @param request 메뉴 수정 요청
     * @return ModifyMenuResponse 수정된 메뉴 정보
     */
    @PatchMapping
    public ApiUtil.ApiResult<ModifyMenuResponse> modifyMenu(@RequestBody ModifyMenuRequest request) {
        Menu menu = modifyMenuUseCase.modifyMenu(request.mapToCommand());
        return success(ModifyMenuResponse.of(menu));
    }

    /**
     * 메뉴 옵션 수정
     *
     * @param request 메뉴 옵션 수정 요청
     * @return ModifyMenuOptionResponse 수정된 메뉴 옵션 정보
     */
    @PatchMapping("/option")
    public ApiUtil.ApiResult<ModifyMenuOptionResponse> modifyMenuOption(@RequestBody ModifyMenuOptionRequest request) {
        MenuOption menuOption = modifyMenuUseCase.modifyMenuOption(request.mapToCommand());
        return success(ModifyMenuOptionResponse.from(menuOption));
    }

}
