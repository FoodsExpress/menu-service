package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.domain.MenuOptionDetail;
import lombok.Data;

@Data
public class ModifyMenuOptionDetailResponse {

    /**
     * 메뉴 옵션 상세 아이디
     */
    private Long menuOptionDetailId;

    /**
     * 메뉴 옵션 식별자
     */
    private String menuOptionId;

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

    public static ModifyMenuOptionDetailResponse from(MenuOptionDetail menuOptionDetail) {
        ModifyMenuOptionDetailResponse response = new ModifyMenuOptionDetailResponse();
        response.menuOptionDetailId = menuOptionDetail.id();
        response.menuOptionId = menuOptionDetail.menuOptionId();
        response.price = menuOptionDetail.price();
        response.orderNumber = menuOptionDetail.orderNumber();
        response.menuOptionDetailName = menuOptionDetail.menuOptionDetailName();
        return response;
    }

}
