package com.test;

public class KMP {
    /**
     *KMP算法求解什么类型问题
     * 字符串匹配。给你两个字符串，
     * 寻找其中一个字符串是否包含另一个字符串，
     * 如果包含，返回包含的起始位置。
     * */

    public static  int getIndexOf(String str1,String str2){
        if (str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()){
            return 1;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s = 0;
        int m = 0;
        int [] next = getNext(s2);//求出str2的最大前缀的next数组
        while(s < s1.length && m < s2.length){
            if (s1[s] == s2[m]){
                s++;
                m++;
            }else if (next[m] == -1){
                s++;
            }else {
                m = next[m];//令m等于最大前缀的后一个与当前s下标的str1比较
            }
        }
        return m == s2.length ? s - m : -1;
    }
    public static int[] getNext(char[] str2){
        if (str2.length == 1){
            return new int[]{-1};
        }
        int [] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while(i < str2.length){
            if (str2[i-1] == str2[cn]){
                next[i++] = cn;
            }else if(cn > 0) {
                cn = next[cn] ;
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }

}
