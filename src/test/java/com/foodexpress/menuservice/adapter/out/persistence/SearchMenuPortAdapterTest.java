package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuCommand;
import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import com.foodexpress.menuservice.application.port.out.RegisterMenuPort;
import com.foodexpress.menuservice.application.port.out.SearchMenuPort;
import com.foodexpress.menuservice.common.containers.MysqlTestContainerInitializer;
import com.foodexpress.menuservice.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class SearchMenuPortAdapterTest extends MysqlTestContainerInitializer {

    @Autowired
    private SearchMenuPort searchMenuPort;

    @Autowired
    private RegisterMenuPort registerMenuPort;

    @Autowired
    private MenuRepository menuRepository;

    @Test
    @DisplayName("메뉴 초기 검색시 결과값들의 storeId가 같은지 테스트")
    void test_case_1() throws Exception {
        // given
        String storeId = "6505762b-6767-4f01-b9a8-10dd016e1b42";
        int size = 10;
        for (int i = 0; i < size; i++) {
            saveMenu(storeId, i + 1);
        }

        SearchMenuQuery searchMenuQuery = new SearchMenuQuery();
        searchMenuQuery.setStoreId(storeId);
        // when
        List<Menu> searchMenuInit = searchMenuPort.getSearchMenuInit(searchMenuQuery, size);
        // then
        for (Menu menu : searchMenuInit) {
            assertEquals(searchMenuQuery.getStoreId(), menu.storeId());
        }

    }

    @Test
    @DisplayName("메뉴 검색 값들이 storeId가 같은지 테스트")
    void test_case_2() throws Exception {
        // given
        String storeId = "6505762b-6767-4f01-b9a8-10dd016e1b42";
        int size = 10;
        for (int i = 0; i < size; i++) {
            saveMenu(storeId, i + 1);
        }
        SearchMenuQuery searchMenuQuery = new SearchMenuQuery();
        searchMenuQuery.setStoreId(storeId);
        // when
        List<Menu> searchMenu = searchMenuPort.getSearchMenu(searchMenuQuery, 10, size);
        // then
        for (Menu menu : searchMenu) {
            assertEquals(searchMenuQuery.getStoreId(), menu.storeId());
        }
    }

    @Test
    @DisplayName("cursor가 0번째일 경우 10번까지 갖고오는지 테스트")
    void test_case_3() throws Exception {
        // given
        String storeId = "6505762b-6767-4f01-b9a8-10dd016e1b42";
        SearchMenuQuery searchMenuQuery = new SearchMenuQuery();
        int size = 10;
        Long menuId = null;
        for (int i = 0; i < size; i++) {
            menuId = saveMenu(storeId, i + 1);
        }
        searchMenuQuery.setStoreId(storeId);
        // when
        List<Menu> searchMenu = searchMenuPort.getSearchMenu(searchMenuQuery, 0, 10);

        assertEquals(menuId, searchMenu.get(0).id());
    }

    @Test
    @DisplayName("메뉴 검색 후 삽입 시 조회 결과에 이상없는지 테스트")
    void test_case_4() throws Exception {
        // given
        String storeId = "6505762b-6767-4f01-b9a8-10dd016e1b42";
        SearchMenuQuery searchMenuQuery = new SearchMenuQuery();
        int size = 20;
        List<Long> menuIds = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            menuIds.add(saveMenu(storeId, i + 1));
        }
        searchMenuQuery.setStoreId(storeId);
        int halfSize = 10;
        // when
        List<Menu> searchMenu = searchMenuPort.getSearchMenu(searchMenuQuery, 0, halfSize);
        Long lastId = searchMenu.getLast().id();

        Long removeId = menuIds.get(5);
        menuRepository.deleteById(removeId);
        searchMenu = searchMenuPort.getSearchMenu(searchMenuQuery, Math.toIntExact(lastId), halfSize);

        Long firstId = searchMenu.getFirst().id();
        // then
        assertEquals(firstId, menuIds.getLast());

    }

    private Long saveMenu(String storeId, int number) {
        RegisterMenuCommand command = new RegisterMenuCommand();
        command.setStoreId(storeId);
        command.setMenuName("메뉴 테스트" + number);
        command.setOrderNumber(number);
        command.setActive(true);
        Menu menu = registerMenuPort.saveMenu(command.mapToDomain());
        return menu.id();
    }

}