package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.common.SelfValidating;
import com.foodexpress.menuservice.domain.ChoiceType;
import com.foodexpress.menuservice.domain.MenuOption;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMenuOptionCommand extends SelfValidating<ModifyMenuOptionCommand> {

    /**
     * 메뉴 옵션 식별자
     */
    private Long menuOptionId;

    /**
     * 필수 여부
     */
    @NotNull
    private boolean required;

    /**
     * 선택 가능 개수
     */
    @Min(1)
    @NotNull
    private int choiceCount;

    /**
     * 선택 유형
     */
    @NotNull
    private ChoiceType choiceType;

    /**
     * 옵션 명
     */
    @NotEmpty
    private String optionName;

    /**
     * 정렬 순서
     */
    @NotNull
    private double orderNumber;

    private List<ModifyMenuOptionDetailCommand> registerMenuOptionDetails;

    public MenuOption mapToDomain() {
        this.validateSelf();
        return MenuOption.builder()
            .id(this.menuOptionId)
            .required(this.required)
            .choiceCount(this.choiceCount)
            .choiceType(this.choiceType)
            .optionName(this.optionName)
            .menuOptionDetails(this.registerMenuOptionDetails.stream().map(ModifyMenuOptionDetailCommand::mapToDomain).toList())
            .build();
    }

}

