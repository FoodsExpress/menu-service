package com.foodexpress.menuservice.application.port.out;

import com.foodexpress.menuservice.domain.Menu;

public interface ModifyMenuOutPort {

    Menu updateMenu(Menu menu);

}
