package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.out.RegisterMenuPort;
import com.foodexpress.menuservice.common.PersistenceAdapter;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterMenuPortAdapter implements RegisterMenuPort {

    private final MenuRepository menuRepository;
    private final MenuOptionRepository menuOptionRepository;
    private final MenuOptionDetailRepository menuOptionDetailRepository;

    @Override
    public Menu saveMenu(Menu menu) {
        MenuEntity menuEntity = MenuEntity.mapToEntity(menu);
        menuRepository.save(menuEntity);
        List<MenuOptionEntity> menuOptions = menuEntity.getMenuOptions();
        if (menuOptions != null && !menuOptions.isEmpty()) {
            menuOptionRepository.saveAll(menuOptions);
            List<MenuOptionDetailEntity> details = new ArrayList<>();
            menuOptions.forEach(o -> details.addAll(o.getMenuOptionDetails()));
            if (!details.isEmpty()) {
                menuOptionDetailRepository.saveAll(details);
            }
        }
        return menuEntity.mapToDomain();
    }

}
