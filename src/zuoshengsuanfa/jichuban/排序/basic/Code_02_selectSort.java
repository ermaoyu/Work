package zuoshengsuanfa.jichuban.排序.basic;

import java.util.Arrays;
import java.util.Collections;

/**
 *      毛毛雨  2018/10/16  选择排序
 * */

public class Code_02_selectSort {

    public static  void selectSort(int[] a){
        if (a == null || a.length == 0){
            return;
        }
        int tmp = 0;
        int falg = 0;
        for (int i = 0;i < a.length; i++){
            falg = i;
            for (int j = i + 1;j < a.length;j++){
                if (a[j] < a[falg]){
                    falg = j;
                }
            }
            if (falg != i){
                tmp = a[falg];
                a[falg] = a[i];
                a[i] = tmp;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int a[] = {3,5,1,6,9,7,2};
        selectSort(a);
        System.out.print(Arrays.toString(a));
    }
}
