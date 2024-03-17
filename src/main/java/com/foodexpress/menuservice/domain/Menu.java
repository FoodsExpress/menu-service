package com.foodexpress.menuservice.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record Menu(
    Long id,
    String menuId,
    // 상점 식별자
    String storeId,
    // 메뉴 명
    String menuName,
    // 메뉴 상세
    String menuDescription,
    // 순서
    double orderNumber,
    // 사용 여부
    boolean active,
    List<MenuOption> menuOptions,
    List<File> menuImages,
    String createdBy,
    LocalDateTime createdDate,
    String updatedBy,
    LocalDateTime updatedDate) {

}
