package com.foodexpress.menuservice.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.menuservice.application.port.in.menu.RegisterMenuOptionCommand;
import com.foodexpress.menuservice.domain.ChoiceType;
import lombok.Data;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class RegisterMenuOptionRequest {

    /**
     * 필수 여부
     */
    @JsonProperty("isRequired")
    private boolean required;

    /**
     * 선택 가능 개수
     */
    private int choiceCount;

    /**
     * 선택 유형
     */
    private ChoiceType choiceType;

    /**
     * 옵션 명
     */
    private String optionName;

    /**
     * 정렬 순서
     */
    private double orderNumber;

    /**
     * 옵션 상세 목록
     */
    private List<RegisterMenuOptionDetailRequest> menuOptionDetailRequests;

    public RegisterMenuOptionCommand mapToCommand() {
        RegisterMenuOptionCommand command = new RegisterMenuOptionCommand();
        copyProperties(this, command);
        command.setRegisterMenuOptionDetails(menuOptionDetailRequests.stream().map(RegisterMenuOptionDetailRequest::mapToCommand).toList());
        return command;
    }

}
