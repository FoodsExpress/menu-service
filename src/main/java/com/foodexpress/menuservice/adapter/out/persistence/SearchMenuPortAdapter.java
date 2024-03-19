package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import com.foodexpress.menuservice.application.port.out.SearchMenuPort;
import com.foodexpress.menuservice.common.PersistenceAdapter;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SearchMenuPortAdapter implements SearchMenuPort {

    private final MenuRepository searchMenuRepository;

    @Override
    public List<Menu> getSearchMenu(SearchMenuQuery command, Integer cursor, Integer size) {

        return searchMenuRepository.findAllBySearchCondition(command, cursor, size);
    }

    @Override
    public List<Menu> getSearchMenuInit(SearchMenuQuery command, Integer cursor, Integer size) {
        return searchMenuRepository.findFirstBySearchCondition(command, cursor, size);
    }

}
