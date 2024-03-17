package com.foodexpress.menuservice.common.advice;

import com.foodexpress.menuservice.common.ApiUtil;
import com.foodexpress.menuservice.common.advice.exceptions.NotPresentMenuException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.foodexpress.menuservice.common.ApiUtil.fail;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiUtil.ApiResult<Void> defaultException(Exception e) {
        e.printStackTrace();
        return fail(e, BAD_REQUEST);
    }

    @ExceptionHandler({
        NotPresentMenuException.class
    })
    @ResponseStatus(BAD_REQUEST)
    public ApiUtil.ApiResult<Void> badRequestException(Exception e) {
        return fail(e, BAD_REQUEST);
    }

}
