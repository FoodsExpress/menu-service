package com.foodexpress.menuservice.application.service;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import com.foodexpress.menuservice.application.port.in.menu.SearchMenuUseCase;
import com.foodexpress.menuservice.application.port.out.SearchMenuPort;
import com.foodexpress.menuservice.common.UseCase;
import com.foodexpress.menuservice.common.properties.PageProperties;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class SearchMenuService implements SearchMenuUseCase {

    private final SearchMenuPort searchMenuPort;

    private final PageProperties pageProperties;

    @Override
    @Transactional(readOnly = true)
    public List<Menu> searchMenu(SearchMenuQuery command, Integer cursor, Integer size) {

        if (size == null) {
            size = pageProperties.getDefaultSize();
        }

        return cursor == null ? searchMenuPort.getSearchMenuInit(command, size) :
            searchMenuPort.getSearchMenu(command, cursor, size);
    }

}
