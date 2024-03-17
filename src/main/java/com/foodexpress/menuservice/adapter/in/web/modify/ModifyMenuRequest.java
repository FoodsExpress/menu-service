package com.foodexpress.menuservice.adapter.in.web.modify;

import com.foodexpress.menuservice.application.port.in.menu.ModifyMenuCommand;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class ModifyMenuRequest {

    private Long menuId;

    private String menuName;

    private String menuDescription;

    private double orderNumber;

    private boolean active;

    public ModifyMenuCommand mapToCommand() {
        ModifyMenuCommand command = new ModifyMenuCommand();
        copyProperties(this, command);
        return command;
    }

}
