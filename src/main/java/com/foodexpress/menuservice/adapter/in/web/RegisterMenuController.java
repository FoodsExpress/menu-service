package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.application.port.in.file.UploadFileCommand;
import com.foodexpress.menuservice.application.port.in.file.UploadFileUseCase;
import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuUseCase;
import com.foodexpress.menuservice.common.ApiUtil;
import com.foodexpress.menuservice.domain.File;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.foodexpress.menuservice.common.ApiUtil.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class RegisterMenuController {

    private final RegisterMenuUseCase registerMenuUseCase;

    private final UploadFileUseCase uploadFileUseCase;

    @PostMapping
    public ApiUtil.ApiResult<RegisterMenuResponse> registerMenu(@RequestBody RegisterMenuRequest request) {
        Menu menu = registerMenuUseCase.registerMenu(request.mapToCommand());
        List<File> files = uploadFileUseCase.uploadFile(UploadFileCommand.of(request.getMenuPhotos(), menu.menuId()));
        return success(RegisterMenuResponse.of(menu));
    }

}
