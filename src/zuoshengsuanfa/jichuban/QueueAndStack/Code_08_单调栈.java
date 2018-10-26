package zuoshengsuanfa.jichuban.QueueAndStack;


import java.util.Arrays;
import java.util.Stack;

/**
 *      毛毛雨      2018/10/25
 *      数组中元素与下一个比它大的元素之间的距离
 * */
public class Code_08_单调栈 {

    public static  int[] nextMaxNum(int[] a){
        if (a.length ==0 || a == null){
            return new int[]{};
        }
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && a[i] > a[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            res[index] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(nextMaxNum(a)));
    }
}
