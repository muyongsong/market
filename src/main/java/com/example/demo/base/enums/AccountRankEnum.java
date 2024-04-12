package com.example.demo.base.enums;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.enums
 * @date 2023/9/14 13:36
 * @description 会员等级枚举类
 */
public enum AccountRankEnum {

    COMMON("COMMON", "普通会员"),

    SILVER("SILVER", "白银会员"),

    GOLDEN("GOLDEN", "黄金会员"),

    DIAMOND("DIAMOND", "钻石会员");

    private  String value;
    private String name;
     AccountRankEnum(String name,String value){
         this.name = name;
         this.value = value;

     }
    public String getValue() {
        return value;
    }

}