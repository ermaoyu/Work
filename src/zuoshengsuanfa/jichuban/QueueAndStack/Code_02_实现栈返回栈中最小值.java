package zuoshengsuanfa.jichuban.QueueAndStack;

import java.util.Stack;

/**
 *      毛毛雨     2018/10/18
 *      【要求】
 *      1．pop、push、getMin操作的时间复杂度都是O(1)。
 *      2．设计的栈类型可以使用现成的栈结构
 * */
public class Code_02_实现栈返回栈中最小值 {
    public static  class MyStack1{
            private Stack<Integer> stackData;
            private Stack<Integer> stackMin;

            public MyStack1(){
                this.stackData = new Stack<Integer>();
                this.stackMin = new Stack<Integer>();
            }

            public void push(int newNum){
                if (this.stackMin.isEmpty()){
                    this.stackMin.push(newNum);
                }else if (newNum <= this.getMin()){
                    this.stackMin.push(newNum);
                }
                this.stackData.push(newNum);
            }
            public int pop(){
                if (this.stackData.isEmpty()){
                    throw new RuntimeException("栈为空");
                }
                int value = this .stackData.pop();
                if (value == this.getMin()){
                    this.stackMin.pop();
                }
                return value;
            }
            public int getMin(){
                if (this.stackMin.isEmpty()){
                    throw new RuntimeException("栈为空");
                }
                return this.stackMin.peek();
            }
        }

}
