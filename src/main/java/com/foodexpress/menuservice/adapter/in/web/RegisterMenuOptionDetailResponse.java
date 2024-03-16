package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.domain.MenuOptionDetail;
import lombok.Data;

@Data
public class RegisterMenuOptionDetailResponse {

    /**
     * 메뉴 옵션 상세 아이디
     */
    private String menuOptionDetailId;

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

    public static RegisterMenuOptionDetailResponse mapToResponse(MenuOptionDetail menuOptionDetail) {
        RegisterMenuOptionDetailResponse response = new RegisterMenuOptionDetailResponse();
        response.menuOptionDetailId = menuOptionDetail.menuOptionDetailId();
        response.menuOptionId = menuOptionDetail.menuOptionId();
        response.price = menuOptionDetail.price();
        response.orderNumber = menuOptionDetail.orderNumber();
        response.menuOptionDetailName = menuOptionDetail.menuOptionDetailName();
        return response;
    }

}
