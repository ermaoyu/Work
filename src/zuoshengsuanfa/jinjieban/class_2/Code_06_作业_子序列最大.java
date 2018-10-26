package zuoshengsuanfa.jinjieban.class_2;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *      毛毛雨     2018/10/25
 *      有一系列整数。您的任务是找到满足以下条件的最长子序列：子序列的最大元素和最小元素之间的差值不小于m且不大于k。
 * */
public class Code_06_作业_子序列最大 {
    public static int sort(int[] a, int m,int k){
        if (a == null || a.length == 0){
            return 0;
        }
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        int R = 0;
        int L = 0;
        int len = 0;
        int index = 0;
        while(R < a.length && L < a.length){
            while (R < a.length){
                while(!max.isEmpty() && a[max.peekLast()] <= a[R])
                    max.pollLast();
                max.addLast(R);
                while (!min.isEmpty() && a[min.peekLast()] >= a[R])
                    min.pollLast();
                min.addLast(R);

                if (a[max.peekFirst()] - a[min.peekFirst()] < m || a[max.peekFirst()] - a[min.peekFirst()] > k){
                    break;
                }

                R++;
            }
            len = Math.max(len,(R - L));
            L++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(sort(a,0,3));
    }
}
