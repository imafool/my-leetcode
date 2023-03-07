package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s){
        //错误码
        int ERROR = -1;
        //字符长度
        int len = s.length();
        //最终结果
        int sum = 0;

        //合法字符
        Map<Character, Integer> legalCharMap = new HashMap<>();
        legalCharMap.put('I', 1);
        legalCharMap.put('V', 5);
        legalCharMap.put('X', 10);
        legalCharMap.put('L', 50);
        legalCharMap.put('C', 100);
        legalCharMap.put('D', 500);
        legalCharMap.put('M', 1000);

        //边界处理
        if (len < 1 || len > 15){
            return ERROR;
        }

        //字符合法判断
        char[] romanCharArray = s.toCharArray();
        for (char c : romanCharArray){
            if (! legalCharMap.containsKey(c)){
                return ERROR;
            }
            sum += legalCharMap.get(c);
        }

        //特殊字符处理
        Map<String, Integer> specialStrMap = new HashMap<>();
        specialStrMap.put("IV", -2);
        specialStrMap.put("IX", -2);
        specialStrMap.put("XL", -20);
        specialStrMap.put("XC", -20);
        specialStrMap.put("CD", -200);
        specialStrMap.put("CM", -200);

        //最终计算
        for (String subStr : specialStrMap.keySet()){
            if (s.contains(subStr)){
                sum += specialStrMap.get(subStr);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("IV"));
        System.out.println(romanToInteger.romanToInt("IX"));
        System.out.println(romanToInteger.romanToInt("LVIII"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
}
