package zuoshengsuanfa.jichuban.排序;

import java.util.Arrays;

/**
 *      毛毛雨     2018/10/17
 * */

public class Code_04_是否有数重复出现 {
    public static void main(String[] args) {
        int []a = {2,4,1,7,45,86,3,1,6,17,1};
    }

    public static  boolean duplicate(int[] a){
        Arrays.sort(a);
        for (int i = 1;i < a.length;i++){
            if (a[i] == a[i-1]){
                return true;
            }
        }
        return false;
    }
}
