package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.domain.Menu;
import lombok.Getter;

@Getter
public class RegisterMenuResponse {

    private Menu menu;

    public static RegisterMenuResponse of(Menu menu) {
        RegisterMenuResponse response = new RegisterMenuResponse();
        response.menu = menu;
        return response;
    }

}
