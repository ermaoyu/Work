package zuoshengsuanfa.jichuban.排序;

import java.util.Arrays;

/**
 *      毛毛雨     2018/10/17
 * */

public class Code_04_是否有数重复出现 {
    //长度为n,数字在0~n-1区间
    public static void main(String[] args) {

        int []a = {2,4,1,7,5,8,3,1,6,7,1};
        System.out.println(duplicate(a));
    }

    public static  boolean duplicate(int[] a){
        if (a == null || a.length ==0){
            return false;
        }
        for (int i = 0;i < a.length;i++) {
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    return true;
                } else {
                    int temp = a[i];
                    a[i] = a[temp];
                    a[temp] = temp;
                }
            }
        }
        return false;
    }
}
