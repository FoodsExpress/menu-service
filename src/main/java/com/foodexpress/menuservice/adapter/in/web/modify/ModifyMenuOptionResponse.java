package com.foodexpress.menuservice.adapter.in.web.modify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.menuservice.domain.ChoiceType;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.Data;

import java.util.List;

@Data
public class ModifyMenuOptionResponse {

    private Long menuOptionId;

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

    private boolean active;

    /**
     * 옵션 상세 목록
     */
    private List<ModifyMenuOptionDetailResponse> menuOptionDetails;

    public static ModifyMenuOptionResponse from(MenuOption menuOption) {
        ModifyMenuOptionResponse response = new ModifyMenuOptionResponse();
        response.menuOptionId = menuOption.id();
        response.required = menuOption.required();
        response.choiceCount = menuOption.choiceCount();
        response.choiceType = menuOption.choiceType();
        response.optionName = menuOption.optionName();
        response.orderNumber = menuOption.orderNumber();
        response.active = menuOption.active();
        response.menuOptionDetails = menuOption.menuOptionDetails().stream().map(ModifyMenuOptionDetailResponse::from).toList();
        return response;
    }

}
