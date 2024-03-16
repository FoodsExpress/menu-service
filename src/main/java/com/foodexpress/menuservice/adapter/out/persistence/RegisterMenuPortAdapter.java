package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.out.RegisterMenuOptionPort;
import com.foodexpress.menuservice.application.port.out.RegisterMenuPort;
import com.foodexpress.menuservice.common.PersistenceAdapter;
import com.foodexpress.menuservice.domain.Menu;
import com.foodexpress.menuservice.domain.MenuOption;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterMenuPortAdapter implements RegisterMenuPort, RegisterMenuOptionPort {

    private final MenuRepository menuRepository;
    private final MenuOptionRepository menuOptionRepository;
    private final MenuOptionDetailRepository menuOptionDetailRepository;

    @Override
    public Menu saveMenu(Menu menu) {
        MenuEntity menuEntity = MenuEntity.mapToEntity(menu);
        menuRepository.save(menuEntity);
        return menuEntity.mapToDomain();
    }

    @Override
    @Transactional
    public List<MenuOption> saveMenuOptions(String menuId, List<MenuOption> menuOptions) {
        MenuEntity menu = menuRepository.findByMenuId(UUID.fromString(menuId)).orElseThrow();
        List<MenuOptionEntity> menuOptionEntities = menuOptions.stream().map(m -> MenuOptionEntity.mapToEntity(m, menu)).toList();
        menuOptionRepository.saveAll(menuOptionEntities);
        List<MenuOptionDetailEntity> detailEntities = new ArrayList<>();
        for (MenuOptionEntity menuOptionEntity : menuOptionEntities) {
            detailEntities.addAll(menuOptionEntity.getMenuOptionDetails());
        }
        menuOptionDetailRepository.saveAll(detailEntities);
        return menuOptionEntities.stream().map(MenuOptionEntity::mapToDomain).toList();
    }

}
