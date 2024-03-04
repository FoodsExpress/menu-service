package com.foodexpress.menuservice.application.port.in;

import com.foodexpress.menuservice.common.SelfValidating;
import com.foodexpress.menuservice.domain.Menu;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMenuCommand extends SelfValidating<RegisterMenuCommand> {

    /**
     * 상점 식별자
     */
    @NotEmpty
    private String storeId;

    /**
     * 메뉴 명
     */
    @NotEmpty
    private String menuName;

    /**
     * 메뉴 설명
     */
    private String menuDescription;

    /**
     * 정렬 순서
     */
    @NotEmpty
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
        this.validateSelf();
        return Menu.builder()
            .storeId(this.storeId)
            .menuName(this.menuName)
            .menuDescription(this.menuDescription)
            .orderNumber(this.orderNumber)
            .menuOptions(this.registerMenuOptionCommands.stream().map(RegisterMenuOptionCommand::mapToDomain).toList())
            .build();
    }

}
