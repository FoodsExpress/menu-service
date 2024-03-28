package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.common.SelfValidating;
import com.foodexpress.menuservice.domain.Menu;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SearchMenuQuery extends SelfValidating<SearchMenuQuery> {

    @NotBlank(message = "스토어를 찾을 수 없습니다.")
    private String storeId;

    private Long menuId;

    private String menuName;

    private String menuDescription;

    private double orderNumber;

    private boolean active;

    public Menu mapToDomain() {
        return Menu.builder()
            .id(this.menuId)
            .storeId(this.storeId)
            .menuName(this.menuName)
            .menuDescription(this.menuDescription)
            .orderNumber(this.orderNumber)
            .active(this.active)
            .build();
    }

}
