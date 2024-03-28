package com.foodexpress.menuservice.adapter.in.web.register;

import lombok.Data;

import java.util.List;

@Data
public class RegisterMenuOptionRequestWrapper {

    private String menuId;

    private List<RegisterMenuOptionRequest> menuOptions;

}
