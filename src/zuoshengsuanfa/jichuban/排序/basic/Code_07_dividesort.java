package zuoshengsuanfa.jichuban.排序.basic;

import java.util.Arrays;

/**
 *   毛毛雨  2018/10/16  二分查找
 * */

public class Code_07_dividesort {

    public static  int  sort(int[] a,int n){
        if (a.length == 0 || a == null || a[a.length-1] < n){
            return -1;
        }
        int low = 0;
        int high = a.length -1;
        while(low <= high){
            int mid = (low + high)/2;
            if (a[mid] == n){
                return mid;
            }else if(a[mid] < n){
                low = mid + 1;
            }else {
                high = mid - 1 ;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,3,4,5,6,7,8 };

        System.out.println(sort(nums,3));
    }
}
