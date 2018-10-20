package zuoshengsuanfa.jichuban.排序;

import java.util.Arrays;

/**
 *    毛毛雨  2018/10/17.
 * */

public class Code_02_相邻两数最大差值 {
    public static  int maxGap(int[] arr){
        if (arr.length <= 1)return 0;
        if (arr.length == 2)return Math.abs(arr[0] - arr[1]);
        Arrays.sort(arr);
        int max = 0;
        for (int i = 1;i<arr.length;i++){
            if (arr[i] - arr[i-1] > max ){
                max = arr[i] - arr[i-1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] a = {1,4,2,3,6,8,7};
        System.out.println(maxGap(a));
    }
}
