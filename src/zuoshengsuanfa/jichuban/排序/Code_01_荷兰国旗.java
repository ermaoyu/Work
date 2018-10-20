package zuoshengsuanfa.jichuban.排序;

import java.util.Arrays;

/**
 *   毛毛雨   2018/10/17  给定num和数组
 * */

public class Code_01_荷兰国旗 {
    public static  void helan(int[] a){
        if (a.length == 0 || a == null){
            return;
        }
        int l = 0;
        int r = a.length-1;
        int tmp = 0;
        int f = 0;
        for (;f <= r ; f++){
            if (a[f] == 0){
                tmp = a[f];
                a[f] = a[l];
                a[l] = tmp;
                l ++ ;
            }else if(a[f] == 2){
                tmp = a[f];
                a[f] = a[r];
                a[r] = tmp;
                r --;
                //因为是从左到右遍历,所以从从右换过来的值也要判断
                f--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0,2,2,1,1,1,1,2,2,2,0,2,0,1,1};
        helan(nums);
        System.out.println(Arrays.toString(nums));
    }
}
