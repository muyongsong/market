package com.example.demo.base.enums;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.enums
 * @date 2023/12/14 17:47
 * @description 用户类型
 */
public enum AccountTypeEnum {

    COMMON("COM", "普通用户"),

    SUPER("SUPER", "管理员");


    private  String value;
    private String name;
    AccountTypeEnum(String name,String value){
        this.name = name;
        this.value = value;

    }
    public String getValue() {
        return value;
    }
}