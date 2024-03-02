package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.out.ModifyMenuOutPort;
import com.foodexpress.menuservice.common.PersistenceAdapter;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class ModifyMenuOutPortAdapter implements ModifyMenuOutPort {

    private final MenuRepository menuRepository;

    @Override
    @Transactional
    public Menu updateMenu(Menu menu) {
        return null;
    }

}
