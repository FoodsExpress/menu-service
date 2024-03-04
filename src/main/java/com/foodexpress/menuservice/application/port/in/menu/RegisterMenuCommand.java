package com.foodexpress.menuservice.application.port.in.menu;

import com.foodexpress.menuservice.domain.Menu;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RegisterMenuCommand {

    /**
     * 메뉴 명
     */
    private String menuName;

    /**
     * 메뉴 설명
     */
    private String menuDescription;

    /**
     * 정렬 순서
     */
    private double orderNumber;

    /**
     * 메뉴 사진 목록
     */
    private List<MultipartFile> menuPhotos;

    /**
     * 메뉴 옵션 목록
     */
    private List<RegisterMenuOptionCommand> registerMenuOptionCommands;

    public Menu mapToDomain() {
        return Menu.builder()
            .menuName(this.menuName)
            .menuDescription(this.menuDescription)
            .orderNumber(this.orderNumber)
            .menuOptions(this.registerMenuOptionCommands.stream().map(RegisterMenuOptionCommand::mapToDomain).toList())
            .build();
    }

}
