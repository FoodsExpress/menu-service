package com.foodexpress.menuservice.adapter.in.web.register;

import com.foodexpress.menuservice.domain.File;
import com.foodexpress.menuservice.domain.Menu;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class RegisterMenuResponse {

    private String menuId;
    private String storeId;
    private String menuName;
    private String menuDescription;
    private double orderNumber;
    private List<File> menuImages;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

    public static RegisterMenuResponse of(Menu menu, List<File> menuImages) {
        RegisterMenuResponse response = new RegisterMenuResponse();
        response.menuId = menu.menuId();
        response.storeId = menu.storeId();
        response.menuName = menu.menuName();
        response.menuDescription = menu.menuDescription();
        response.orderNumber = menu.orderNumber();
        response.menuImages = menuImages;
        response.createdBy = menu.createdBy();
        response.updatedBy = menu.updatedBy();
        response.createdDate = menu.createdDate();
        response.updatedDate = menu.updatedDate();
        return response;
    }

}
