package zuoshengsuanfa.jichuban.排序.basic;

import java.util.Arrays;

/**
 *      毛毛雨  2018/10/16  插入排序
 * */
public class Code_03_insertSort {

    public static  void insertSort(int[] a){
        if (a.length == 0 || a == null){
            return;
        }
        int tmp = 0;
        for (int i = 0;i < a.length-1; i++){
           int j = i;
           tmp = a[i+1];
           while(j > -1 && a[j] > tmp){
               a[j + 1] = a[j];
               j--;
           }
           a[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int a[] = {3,5,1,6,9,7,2};
        insertSort(a);
         System.out.print(Arrays.toString(a));
    }
}
