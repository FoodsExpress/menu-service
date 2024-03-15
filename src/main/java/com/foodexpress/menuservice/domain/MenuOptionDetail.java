package com.foodexpress.menuservice.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MenuOptionDetail(
    Long id,
    String menuOptionId,
    String menuOptionDetailId,
    double orderNumber,
    double price,
    String menuOptionDetailName,
    String createdBy,
    LocalDateTime createdDate,
    String updatedBy,
    LocalDateTime updatedDate
) {

}
