package com.example.demo.base.unit;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.unit
 * @date 2024/5/31 10:29
 * @description TODO
 */
public class test {

    public static String reverseTestSix(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String ss =  reverseTestSix(s.substring(1)) + s.substring(0, 1);
        return  ss;
    }


    public static void main(String[] args) {

        System.out.println( reverseTestSix("HKSLOWKS"));
    }

}