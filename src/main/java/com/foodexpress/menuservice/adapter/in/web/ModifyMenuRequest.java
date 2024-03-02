package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.application.port.in.ModifyMenuCommand;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class ModifyMenuRequest {

    /**
     * 메뉴 식별자
     */
    private Long menuId;

    /**
     * 메뉴 명
     */
    private String menuName;

    /**
     * 메뉴 설명
     */
    private String menuDescription;

    /**
     * 정렬 순서
     */
    private double orderNumber;

    public ModifyMenuCommand mapToCommand() {
        ModifyMenuCommand command = new ModifyMenuCommand();
        copyProperties(this, command);
        return command;
    }

}
