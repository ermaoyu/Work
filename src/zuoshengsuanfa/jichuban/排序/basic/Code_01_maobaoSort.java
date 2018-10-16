package zuoshengsuanfa.jichuban.排序.basic;

import java.util.Arrays;

/**
 *      毛毛雨  2018/10/16  冒泡排序
 * */
public class Code_01_maobaoSort {

    public static  void sort(int [] a){
        if (a == null || a.length == 0){
            return;
        }
        int n = a.length;
        for (int i = 0;i < n -1;i++){
            for (int j = 0;j < n - i -1 ;j++){
                if (a[j] > a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
         int a[] = {3,5,1,6,9,7,2};
         sort(a);
         System.out.print(Arrays.toString(a));
    }

}
