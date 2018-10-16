package zuoshengsuanfa.jichuban.排序.basic;

import java.util.Arrays;

/**
 *   毛毛雨  2018/10/16  快速排序
 * */

public class Code_05_quickSort {

    public static  void sort(int[] a, int low,int high){
        if (a.length == 0 || a == null){
            return ;
        }
        int i = low;
        int j = high;
        if ( i > j){
            return ;
        }
        int index = a[low];
        while(i < j){
            while(i < j && a[j] > index)j--;
            if (i < j) a[i++] = a[j];
            while (i < j && a[i] <= index)i++;
            if (i < j)a[j--] = a[i];
        }
        a[i] = index;
        sort(a,0,i-1);
        sort(a,i+1,high);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }


}
