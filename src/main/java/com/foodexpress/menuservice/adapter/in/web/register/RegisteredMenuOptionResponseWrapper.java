package com.foodexpress.menuservice.adapter.in.web.register;

import lombok.Data;

import java.util.List;

@Data
public class RegisteredMenuOptionResponseWrapper {

    private String menuId;

    private List<RegisteredMenuOptionResponse> menuOptions;

    public static RegisteredMenuOptionResponseWrapper of(String menuId, List<RegisteredMenuOptionResponse> menuOptions) {
        RegisteredMenuOptionResponseWrapper wrapper = new RegisteredMenuOptionResponseWrapper();
        wrapper.menuId = menuId;
        wrapper.menuOptions = menuOptions;
        return wrapper;
    }

}
