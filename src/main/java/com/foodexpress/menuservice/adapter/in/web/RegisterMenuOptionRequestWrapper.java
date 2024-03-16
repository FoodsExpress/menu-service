package com.foodexpress.menuservice.adapter.in.web;

import lombok.Data;

import java.util.List;

@Data
public class RegisterMenuOptionRequestWrapper {

    private String menuId;

    private List<RegisterMenuOptionRequest> menuOptions;

}
