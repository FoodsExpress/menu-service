package com.foodexpress.menuservice.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record MenuOption(
    Long id,
    String menuOptionId,
    String menuId,
    boolean required,
    int choiceCount,
    ChoiceType choiceType,

    String optionName,
    double orderNumber,
    boolean active,
    List<MenuOptionDetail> menuOptionDetails,
    String createdBy,
    LocalDateTime createdDate,
    String updatedBy,
    LocalDateTime updatedDate) {

}
