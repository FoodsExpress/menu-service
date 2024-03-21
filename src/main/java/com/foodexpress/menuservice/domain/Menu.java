package com.foodexpress.menuservice.domain;

import com.foodexpress.menuservice.adapter.out.persistence.MenuDTO;
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

    public static Menu convert(MenuDTO menuDTO) {
        return Menu.builder()
            .id(menuDTO.getId())
            .storeId(menuDTO.getStoreId())
            .menuId(menuDTO.getMenuId())
            .menuName(menuDTO.getMenuName())
            .menuDescription(menuDTO.getMenuDescription())
            .orderNumber(menuDTO.getOrderNumber())
            .active(menuDTO.isActive())
            .createdBy(menuDTO.getCreatedBy())
            .createdDate(menuDTO.getCreatedDate())
            .updatedBy(menuDTO.getUpdatedBy())
            .updatedDate(menuDTO.getUpdatedDate())
            .build();
    }

}
