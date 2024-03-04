package com.foodexpress.menuservice.adapter.in.web;

import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuCommand;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * 메뉴 등록 요청 객체
 *
 * @author seunggu.lee
 */
@Data
public class RegisterMenuRequest {

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
    private List<RegisterMenuOptionRequest> registerMenuOptionRequests;

    public RegisterMenuCommand mapToCommand() {
        RegisterMenuCommand command = new RegisterMenuCommand();
        copyProperties(this, command);
        command.setRegisterMenuOptionCommands(this.registerMenuOptionRequests.stream().map(RegisterMenuOptionRequest::mapToCommand).toList());
        return command;
    }

}
