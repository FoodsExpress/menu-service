package com.foodexpress.menuservice.adapter.in.web.search;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuUseCase;
import com.foodexpress.menuservice.common.ApiUtil;
import com.foodexpress.menuservice.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.foodexpress.menuservice.common.ApiUtil.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class SearchMenuController {

    private final SearchMenuUseCase searchMenuUseCase;

    /**
     * 메뉴 조회
     *
     * @param request 메뉴 조회 요청
     * @return SearchMenuResponse 조회한 메뉴 정보
     */
    @GetMapping
    public ApiUtil.ApiResult<SearchMenuResponse> searchMenu(@RequestBody SearchMenuRequest request) {
        List<Menu> searchMenu = searchMenuUseCase.searchMenu(request.convertCommand(), request.getCursor(), request.getSize());
        return success(SearchMenuResponse.of(searchMenu));
    }

}
