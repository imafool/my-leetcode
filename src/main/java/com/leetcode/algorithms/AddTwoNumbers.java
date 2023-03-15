package com.leetcode.algorithms;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * #2 两数相加
 */
public class AddTwoNumbers {

    private static BigDecimal getNum(ListNode l) {
        int n = -1;
        BigDecimal sum = new BigDecimal(0);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (l.next != null){
            hashMap.put(++n, l.val);//介:值
            l = l.next;
        }
        hashMap.put(++n, l.val);
        for (Integer bet : hashMap.keySet()){
            sum = sum.add(BigDecimal.valueOf(hashMap.get(bet)).multiply(new BigDecimal(10).pow(bet)));
        }
        return sum;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        char[] chars = getNum(l1).add(getNum(l2)).toString().toCharArray();
        ListNode listNode = null;
        for (int i=0; i < chars.length; i++){
            if (i == chars.length - 1)
                return new ListNode(chars[chars.length - 1] - '0', listNode);
            if (i == 0)
                listNode = new ListNode(chars[0] - '0');
            else
                listNode = new ListNode(chars[i] - '0', listNode);
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO 测试用例
    }
}

