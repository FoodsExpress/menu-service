package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.domain.ChoiceType;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.Data;

import java.util.List;

@Data
public class RegisterMenuOptionCommand {

    /**
     * 필수 여부
     */
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

    private List<RegisterMenuOptionDetailCommand> registerMenuOptionDetails;

    public MenuOption mapToDomain() {
        return MenuOption.builder()
            .required(this.required)
            .choiceCount(this.choiceCount)
            .choiceType(this.choiceType)
            .optionName(this.optionName)
            .menuOptionDetails(this.registerMenuOptionDetails.stream().map(RegisterMenuOptionDetailCommand::mapToDomain).toList())
            .build();
    }

}
