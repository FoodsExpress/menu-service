package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.application.port.in.file.UploadFileCommand;
import com.foodexpress.menuservice.application.port.in.file.UploadFileUseCase;
import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuOptionUseCase;
import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuUseCase;
import com.foodexpress.menuservice.common.ApiUtil;
import com.foodexpress.menuservice.domain.File;
import com.foodexpress.menuservice.domain.Menu;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.foodexpress.menuservice.common.ApiUtil.success;

/**
 * 메뉴 등록 컨트롤러
 *
 * @author seunggu.lee
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class RegisterMenuController {

    private final RegisterMenuUseCase registerMenuUseCase;

    private final UploadFileUseCase uploadFileUseCase;

    private final RegisterMenuOptionUseCase registerMenuOptionUseCase;

    /**
     * 메뉴 등록
     *
     * @param request 메뉴 등록 요청 객체
     * @return 등록된 메뉴
     */
    @PostMapping
    public ApiUtil.ApiResult<RegisterMenuResponse> registerMenu(@RequestBody RegisterMenuRequest request) {
        Menu menu = registerMenuUseCase.registerMenu(request.mapToCommand());
        List<File> files = uploadFileUseCase.uploadFile(UploadFileCommand.of(request.getMenuPhotos(), menu.menuId()));
        return success(RegisterMenuResponse.of(menu, files));
    }

    @PostMapping
    public ApiUtil.ApiResult<RegisteredMenuOptionResponseWrapper> registerMenuOption(@RequestBody RegisterMenuOptionRequestWrapper request) {
        List<MenuOption> menuOptions = registerMenuOptionUseCase.registerMenuOptions(request.getMenuId(),
                                                                                     request.getMenuOptions().stream().map(
                                                                                         RegisterMenuOptionRequest::mapToCommand).toList());
        return success(RegisteredMenuOptionResponseWrapper.of(request.getMenuId(),
                                                              menuOptions.stream().map(RegisteredMenuOptionResponse::mapToResponse).toList()));
    }

}
