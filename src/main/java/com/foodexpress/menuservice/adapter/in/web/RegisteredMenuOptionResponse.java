package com.foodexpress.menuservice.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.menuservice.domain.ChoiceType;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.Data;

import java.util.List;

@Data
public class RegisteredMenuOptionResponse {

    private String menuOptionId;

    private String menuId;

    /**
     * 필수 여부
     */
    @JsonProperty("isRequired")
    private boolean required;

    /**
     * 선택 가능 개수
     */
    private int choiceCount;

    /**
     * 선택 유형
     */
    private ChoiceType choiceType;

    /**
     * 옵션 명
     */
    private String optionName;

    /**
     * 정렬 순서
     */
    private double orderNumber;

    /**
     * 옵션 상세 목록
     */
    private List<RegisterMenuOptionDetailResponse> menuOptionDetailResponses;

    public static RegisteredMenuOptionResponse mapToResponse(MenuOption menuOption) {
        RegisteredMenuOptionResponse response = new RegisteredMenuOptionResponse();
        response.menuOptionId = menuOption.menuOptionId();
        response.required = menuOption.required();
        response.choiceCount = menuOption.choiceCount();
        response.choiceType = menuOption.choiceType();
        response.optionName = menuOption.optionName();
        response.orderNumber = menuOption.orderNumber();
        response.menuOptionDetailResponses =
            menuOption.menuOptionDetails().stream().map(RegisterMenuOptionDetailResponse::mapToResponse).toList();
        return response;
    }

}
