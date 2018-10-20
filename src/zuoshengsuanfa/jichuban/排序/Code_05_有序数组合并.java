package zuoshengsuanfa.jichuban.排序;

import java.util.Arrays;

/**
 *      毛毛雨     2018/10/17
 * */
public class Code_05_有序数组合并 {
    //1 3 5
    //2 4 6
    //从前往后,两两比较,小的先放,大的放次后
    public static int[] combinSortArrays(int[] a,int[] b){
        int i = 0;
        int j = 0;
        int len = (a.length+b.length);
        int[] c = new int [len];
        int index = 0;
        while(i < a.length && j < b.length){
            if (a[i] < b[j]){
                c[index++] = a[i++];
            }else {
                c[index++] = b[j++];
            }
        }
        while (i < a.length){
            c[index++] = a[i++];
        }
        while (j < b.length){
            c[index++] = b[j++];
        }
        return c;
    }
    public static void main(String[] args) {
        int []a = new int[2];
        int []b = new int[4];
        b[0] = 2;
        b[1] = 4;
        b[2] = 6;
        b[3] = 8;
        a[0] = 1;
        a[1] = 3;

        System.out.println(Arrays.toString(combinSortArrays(a, b)));
    }
}
