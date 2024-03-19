package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import com.foodexpress.menuservice.application.port.out.SearchMenuPort;
import com.foodexpress.menuservice.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class SearchMenuPortAdapterTest {

    @Autowired
    private SearchMenuPort searchMenuPort;

    @Test
    @DisplayName("메뉴 초기 검색시 결과값들의 storeId가 같은지 테스트")
    void test_case_1() throws Exception {
        // given
        SearchMenuQuery searchMenuQuery = new SearchMenuQuery();
        searchMenuQuery.setStoreId("6505762b-6767-4f01-b9a8-10dd016e1b42");
        // when
        List<Menu> searchMenuInit = searchMenuPort.getSearchMenuInit(searchMenuQuery, 10);
        // then

        for (Menu menu : searchMenuInit) {
            assertEquals(searchMenuQuery.getStoreId(), menu.storeId());
        }

    }

    @Test
    @DisplayName("메뉴 검색 값들이 storeId가 같은지 테스트")
    void test_case_2() throws Exception {
        // given
        SearchMenuQuery searchMenuQuery = new SearchMenuQuery();
        searchMenuQuery.setStoreId("6505762b-6767-4f01-b9a8-10dd016e1b42");
        // when
        List<Menu> searchMenu = searchMenuPort.getSearchMenu(searchMenuQuery, 10, 10);
        // then

        for (Menu menu : searchMenu) {
            assertEquals(searchMenuQuery.getStoreId(), menu.storeId());
        }
    }

}