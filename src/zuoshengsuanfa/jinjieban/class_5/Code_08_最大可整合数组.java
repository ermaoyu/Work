package zuoshengsuanfa.jinjieban.class_5;

import java.util.HashSet;

/**
 *        毛毛雨       2018/11/1
 *        。如果一个数组在排序之后，每相邻两个数差的绝对 值都为1，
 *        则该数组为可整合数组
 * */
public class Code_08_最大可整合数组 {

    public static int sort(int[] a){
        if (a.length == 0 || a == null){
            return 0;
        }
        int len = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < a.length; j++) {
                if (set.contains(a[j])){
                    break;
                }
                set.add(a[j]);
                max = Math.max(max,a[j]);
                min = Math.min(min,a[j]);
                if (max - min == j - i){
                    len = Math.max(len,j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 5, 3, 2, 6, 4, 3 };
        System.out.println(sort(arr));
    }
}
