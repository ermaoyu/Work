package arthmetic;

import java.util.Stack;

public class feibonaqi {
    /**
     * 题目描述
     * 大家都知道斐波那契数列，现在要求输入一个整数n，
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * **/
    public int Fibonacci(int n) {
        int res = 0;
        int inres = 1;
        int temp = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(inres);
        if(n<0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else {
            for (int i = 0; i < n; i++) {
                temp = res;
                res = inres + res;
                inres = temp;
                stack.push(res);
            }
        }

        return  res;
    }
}
