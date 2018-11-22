package zuoshengsuanfa.jinjieban.class_6;

import java.util.Arrays;

/**
 *      毛毛雨     2018/11/2
 * 给定一个整型数组，请在原地调整这个数组，保证要么偶数位 置上都是偶数，
 * 或者奇数位置上都是奇数。
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 * */
public class Code_01_原地修改数组 {
    public static void modify(int[] a){
        if (a == null || a.length == 0){
            return;
        }
        int onum = 0;
        int jnum = 1;
        int end = a.length -1;
        for (;onum <= end && jnum <= end;) {
            if ((a[end] & 1) == 0){
                swap(a,onum,end);
                onum += 2;
            }else {
                swap(a,jnum,end);
                jnum += 2;
            }
        }
    }

    public static void swap(int[] a,int index,int end){
        int tmp = a[end];
        a[end] = a[index];
        a[index] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 3, 2, 4, 6};
        modify(a);
        System.out.println(Arrays.toString(a));
    }
}
