package com.foodexpress.menuservice.application.port.in;

import com.foodexpress.menuservice.domain.MenuOptionDetail;
import lombok.Data;

@Data
public class RegisterMenuOptionDetailCommand {

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

    public MenuOptionDetail mapToDomain() {
        return MenuOptionDetail.builder()
            .orderNumber(this.orderNumber)
            .menuOptionDetailName(this.menuOptionDetailName)
            .build();

    }

}
