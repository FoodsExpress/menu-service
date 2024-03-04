package com.foodexpress.menuservice.application.port.in;

import com.foodexpress.menuservice.common.SelfValidating;
import com.foodexpress.menuservice.domain.MenuOptionDetail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMenuOptionDetailCommand extends SelfValidating<RegisterMenuOptionDetailCommand> {

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
            .orderNumber(this.orderNumber)
            .menuOptionDetailName(this.menuOptionDetailName)
            .build();

    }

}
