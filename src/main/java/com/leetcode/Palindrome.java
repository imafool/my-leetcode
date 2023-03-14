package com.leetcode;

/**
 * #9 回文数
 */
public class Palindrome {

    public boolean isPalindrome(int x) {
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE || x < 0){
            return Boolean.FALSE;
        }

        // 个位数直接返回
        if (x >= 0 && x < 9){
            return Boolean.TRUE;
        }

        //字符串处理
        String xStr = String.valueOf(x);
        int len = xStr.length();

        String preStr = xStr.substring(0, len / 2);
        String sufStr = "";

        //再判断奇数偶数
        if (len % 2 == 0){
            sufStr = xStr.substring(len / 2, len);
        } else {
            sufStr = xStr.substring(len / 2 + 1, len);
        }

        //反转
        String reverseStr = Palindrome.reverse(sufStr);

        //比较
        if (preStr.equals(reverseStr)){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    //输出函数
    public static void print(Boolean b){
        System.out.println(b);
    }

    //反转字符串
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        // 测试用例
        Palindrome palindrome = new Palindrome();
        print(palindrome.isPalindrome(121));
        print(palindrome.isPalindrome(10));
        print(palindrome.isPalindrome(-121));
        print(palindrome.isPalindrome(11));
        print(palindrome.isPalindrome(1001));
    }
}
