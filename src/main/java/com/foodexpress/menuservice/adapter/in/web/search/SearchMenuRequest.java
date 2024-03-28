package com.foodexpress.menuservice.adapter.in.web.search;

import com.foodexpress.menuservice.application.port.in.menu.SearchMenuQuery;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class SearchMenuRequest {

    private Long id;

    /**
     * 상점 식별자
     */
    private String storeId;

    /**
     * 메뉴 명
     */
    private String menuName;

    /**
     * 메뉴 상세 설명
     */
    private String menuDescription;

    /**
     * 사용 여부
     */
    private boolean active = Boolean.TRUE;

    /**
     * 커서 위치
     */
    private Integer cursor;

    /**
     * 페이지 사이즈
     */
    private Integer size;

    public SearchMenuQuery convertCommand() {
        SearchMenuQuery command = new SearchMenuQuery();
        copyProperties(this, command);
        return command;
    }

}
