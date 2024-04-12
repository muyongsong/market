package com.example.demo.global.config;

import lombok.Data;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.global.config
 * @date 2023/4/11 08:28
 * @description TODO
 */
@Data
public class GlobalException extends RuntimeException{

        private final Integer code;


    /**
     * 通过状态码和异常信息创建异常对象
     * @param code
     * @param message
     */
    public GlobalException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    /**
     * 接受枚举类型对象
     * @param responseEnum
     */
    public GlobalException(ResponseEnum responseEnum) {
        super(responseEnum.getResultMessage());
        this.code = responseEnum.getCode();

    }

}