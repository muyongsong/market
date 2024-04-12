package com.example.demo.global.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.global.config
 * @date 2023/4/11 08:25
 * @description 相应状态枚举类
 */

@AllArgsConstructor
@Getter
public enum ResponseEnum {

    SUCCESS(200, "操作成功"),
    FAIL(201, "获取数据失败"),
    NO_TOKEN(400, "无token，请重新登录"),
    TOKEN_EX(401, "token验证失败，请重新登录"),
    USER_EX(402, "用户不存在，请重新登录"),
    ERROR(400, "错误请求");

    /**
     * 响应码
     **/
    private final Integer code;

    /**
     * 结果
     **/
    private final String resultMessage;

    public static ResponseEnum getResultCode(Integer code) {
        for (ResponseEnum value : ResponseEnum.values()) {
            if (code.equals(value.getCode())) {
                return value;
            }
        }
        return ResponseEnum.ERROR;
    }
}