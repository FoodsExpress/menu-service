package com.foodexpress.menuservice.adapter.in.web.modify;

import com.foodexpress.menuservice.domain.Menu;
import lombok.Data;

@Data
public class ModifyMenuResponse {

    private Long id;

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

    /**
     * 사용 여부
     */
    private boolean active;

    public static ModifyMenuResponse of(Menu menu) {
        ModifyMenuResponse response = new ModifyMenuResponse();
        response.id = menu.id();
        response.menuName = menu.menuName();
        response.menuDescription = menu.menuDescription();
        response.orderNumber = menu.orderNumber();
        response.active = menu.active();
        return response;
    }

}
