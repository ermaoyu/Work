package arthmetic;

import java.util.Stack;

/**
 *      毛毛雨     2018/10/29
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * */
public class 包含min函数的栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    public void push(int node) {
        if (min.isEmpty()){
            min.push(node);
        }else if (node < min.peek()){
            min.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        int index = stack.pop();
        if (min.peek() == index){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
