package com.foodexpress.menuservice.adapter.in.web.modify;

import com.foodexpress.menuservice.application.port.in.menu.ModifyMenuOptionDetailCommand;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class ModifyMenuOptionDetailRequest {

    /**
     * 메뉴 옵션 식별자
     */
    private Long menuOptionDetailId;

    /**
     * 가격
     */
    private double price;

    /**
     * 정렬 순서
     */
    private double orderNumber;

    /**
     * 옵션 상세 명
     */
    private String menuOptionDetailName;

    public ModifyMenuOptionDetailCommand mapToCommand() {
        ModifyMenuOptionDetailCommand command = new ModifyMenuOptionDetailCommand();
        copyProperties(this, command);
        return command;
    }

}
