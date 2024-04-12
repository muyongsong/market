package com.example.demo.global.config;

import com.example.demo.global.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.global.config
 * @date 2023/4/11 09:31
 * @description TODO
 */
@RestControllerAdvice
public class GlobalExceptionConfig {


    @ExceptionHandler(GlobalException.class)
    public Result<GlobalException> handle(GlobalException e) {
        e.printStackTrace();
        return Result.exception(e.getCode(), e.getMessage());
    }

}