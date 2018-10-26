package zuoshengsuanfa.jinjieban.class_2;

import java.util.Arrays;
import java.util.Stack;

/**
 *      毛毛雨     2018/10/21
 *      给定一个数组求出每一个数左边离它最近比他大的数和
 *      右边最近比他大的数
 * */
public class Code_03_介绍单调栈结构 {

    public static int[][] getNearLessMax(int[] a){
        int [][] res = new int [a.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < a.length;i++){
            while(!stack.isEmpty() && a[stack.peek()] < a[i]){
                int popindex = stack.pop();
                int leftlessindex = stack.peek();
                res[popindex][0] = leftlessindex;
                res[popindex][1] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int popindex = stack.pop();
            int leftlessindex = stack.isEmpty()? -1 : stack.peek();
            res[popindex][0] = leftlessindex;
            res[popindex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4,3,4};
        System.out.println(Arrays.toString(getNearLessMax(a)));
    }
}
