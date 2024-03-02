package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.application.port.in.ModifyMenuUseCase;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class ModifyMenuController {

    private final ModifyMenuUseCase modifyMenuUseCase;

    @PatchMapping
    public void modifyMenu(@RequestBody ModifyMenuRequest request) {
        Menu menu = modifyMenuUseCase.modifyMenu(request.mapToCommand());
    }

}
