package com.foodexpress.menuservice.adapter.in.web.search;

import com.foodexpress.menuservice.domain.File;
import com.foodexpress.menuservice.domain.Menu;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchMenuResponse {

    private List<Menu> menuList;
    private List<File> menuImages;

    public static SearchMenuResponse of(List<Menu> menu) {
        SearchMenuResponse response = new SearchMenuResponse();
        response.menuList = menu;
        return response;
    }

}
