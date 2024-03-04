package com.foodexpress.menuservice.application.port.out;

import com.foodexpress.menuservice.domain.Menu;

public interface RegisterMenuPort {

    Menu saveMenu(Menu menu);

}
