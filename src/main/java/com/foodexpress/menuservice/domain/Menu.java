package com.foodexpress.menuservice.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record Menu(
    Long id,
    String menuId,
    String menuName,
    String menuDescription,
    double orderNumber,
    List<MenuOption> menuOptions,
    String createdBy,
    LocalDateTime createdDate,
    String updatedBy,
    LocalDateTime updatedDate) {

}
