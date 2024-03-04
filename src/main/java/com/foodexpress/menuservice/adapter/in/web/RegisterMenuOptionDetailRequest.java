package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuOptionDetailCommand;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class RegisterMenuOptionDetailRequest {

    /**
     * 메뉴 옵션 식별자
     */
    private String menuOptionId;

    /**
     * 정렬 순서
     */
    private double orderNumber;

    /**
     * 옵션 상세 명
     */
    private String menuOptionDetailName;

    public RegisterMenuOptionDetailCommand mapToCommand() {
        RegisterMenuOptionDetailCommand command = new RegisterMenuOptionDetailCommand();
        copyProperties(this, command);
        return command;
    }

}
