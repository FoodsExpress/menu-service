package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.common.SelfValidating;
import com.foodexpress.menuservice.domain.MenuOptionDetail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMenuOptionDetailCommand extends SelfValidating<ModifyMenuOptionDetailCommand> {

    /**
     * 메뉴 옵션 상세 식별자
     */
    private Long menuOptionDetailId;

    /**
     * 가격
     */
    @NotNull
    private double price;

    /**
     * 정렬 순서
     */
    @NotNull
    private double orderNumber;

    /**
     * 옵션 상세 명
     */
    @NotEmpty
    private String menuOptionDetailName;

    public MenuOptionDetail mapToDomain() {
        this.validateSelf();
        return MenuOptionDetail.builder()
            .id(this.menuOptionDetailId)
            .price(this.price)
            .orderNumber(this.orderNumber)
            .menuOptionDetailName(this.menuOptionDetailName)
            .build();

    }

}
