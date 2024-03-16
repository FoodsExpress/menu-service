package com.foodexpress.menuservice.common.advice.exceptions;

public class NotPresentMenuException extends RuntimeException {

    public NotPresentMenuException() {
        super("존재하는 메뉴가 없습니다.");
    }

}
