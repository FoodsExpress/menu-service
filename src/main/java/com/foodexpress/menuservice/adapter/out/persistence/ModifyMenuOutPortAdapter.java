package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.out.ModifyMenuOutPort;
import com.foodexpress.menuservice.common.PersistenceAdapter;
import com.foodexpress.menuservice.domain.Menu;
import com.foodexpress.menuservice.domain.MenuOption;
import com.foodexpress.menuservice.domain.MenuOptionDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@PersistenceAdapter
@RequiredArgsConstructor
public class ModifyMenuOutPortAdapter implements ModifyMenuOutPort {

    private final MenuRepository menuRepository;
    private final MenuOptionRepository menuOptionRepository;
    private final MenuOptionDetailRepository menuOptionDetailRepository;

    @Override
    @Transactional
    public Menu updateMenu(Menu menu) {
        MenuEntity entity = menuRepository.findById(menu.id()).orElseThrow();
        entity.sync(menu);
        return entity.mapToDomain();
    }

    @Override
    @Transactional
    public MenuOption updateMenuOption(MenuOption menuOption) {
        MenuOptionEntity optionEntity = menuOptionRepository.findById(menuOption.id()).orElseThrow();
        optionEntity.sync(menuOption);
        saveMenuOptionDetail(menuOption, optionEntity);
        List<MenuOptionDetailEntity> menuOptionDetailList = menuOptionDetailRepository.findAllByMenuOptionId(menuOption.id());
        return optionEntity.mapToDomain(menuOptionDetailList.stream().map(MenuOptionDetailEntity::mapToDomain).toList());
    }

    private void saveMenuOptionDetail(MenuOption menuOption, MenuOptionEntity optionEntity) {
        List<MenuOptionDetail> menuOptionDetails = menuOption.menuOptionDetails();
        List<Long> deleteList = new ArrayList<>();
        List<MenuOptionDetailEntity> insertList = new ArrayList<>();
        List<MenuOptionDetailEntity> menuOptionDetailList = menuOptionDetailRepository.findAllByMenuOptionId(menuOption.id());
        Map<Long, MenuOptionDetailEntity> optionDetailMap = new HashMap<>();
        for (MenuOptionDetailEntity entity : menuOptionDetailList) {
            optionDetailMap.put(entity.getId(), entity);
        }
        for (MenuOptionDetail menuOptionDetail : menuOptionDetails) {
            if (menuOptionDetail.id() == null) {
                insertList.add(MenuOptionDetailEntity.mapToEntity(menuOptionDetail, optionEntity));
                continue;
            }
            Optional<MenuOptionDetailEntity> optionalEntity = Optional.ofNullable(optionDetailMap.get(menuOptionDetail.id()));
            optionalEntity.ifPresent(mod -> {
                mod.sync(menuOptionDetail);
                optionDetailMap.remove(menuOptionDetail.id());
            });
        }
        for (Map.Entry<Long, MenuOptionDetailEntity> entry : optionDetailMap.entrySet()) {
            deleteList.add(entry.getKey());
        }
        menuOptionDetailRepository.deleteAllById(deleteList);
        menuOptionDetailRepository.saveAll(insertList);
    }

}
