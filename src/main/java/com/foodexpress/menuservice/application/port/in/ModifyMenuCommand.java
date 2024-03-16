package com.foodexpress.menuservice.application.port.in;

import com.foodexpress.menuservice.domain.Menu;
import lombok.Data;

@Data
public class ModifyMenuCommand {

    private Long menuId;

    private String menuName;

    private String menuDescription;

    private double orderNumber;

    private boolean active;

    public Menu mapToDomain() {
        return Menu.builder()
            .id(this.menuId)
            .menuName(this.menuName)
            .menuDescription(this.menuDescription)
            .orderNumber(this.orderNumber)
            .active(this.active)
            .build();
    }

}
