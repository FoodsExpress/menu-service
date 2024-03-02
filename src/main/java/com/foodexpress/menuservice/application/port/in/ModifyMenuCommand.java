package com.foodexpress.menuservice.application.port.in;

import com.foodexpress.menuservice.common.SelfValidating;
import com.foodexpress.menuservice.domain.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMenuCommand extends SelfValidating<ModifyMenuCommand> {

    /**
     * 메뉴 식별자
     */
    private Long menuId;

    /**
     * 메뉴 명
     */
    private String menuName;

    /**
     * 메뉴 설명
     */
    private String menuDescription;

    /**
     * 정렬 순서
     */
    private double orderNumber;

    public Menu mapToDomain() {
        return Menu.builder()
            .id(menuId)
            .menuName(menuName)
            .build();

    }

}
