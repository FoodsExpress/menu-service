package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.domain.File;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class MenuDTO {

    Long id;

    UUID menuId;

    String storeId;

    String menuName;

    String menuDescription;

    double orderNumber;

    boolean active;

    List<MenuOption> menuOptions;

    List<File> menuImages;

    String createdBy;

    LocalDateTime createdDate;

    String updatedBy;

    LocalDateTime updatedDate;

}
