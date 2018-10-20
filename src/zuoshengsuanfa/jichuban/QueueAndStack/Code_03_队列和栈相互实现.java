package zuoshengsuanfa.jichuban.QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *      毛毛雨     2018/10/18
 *      如何仅用队列结构实现栈结构？
 *      如何仅用栈结构实现队列结构
 * */
public class Code_03_队列和栈相互实现 {

    public static class QueueToStack{
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public QueueToStack() {
            this.queue1 = new LinkedList<Integer>();
            this.queue2 = new LinkedList<Integer>();
        }

        public void push(int pushInt){
            queue1.add(pushInt);
        }

        public int peek(){
            if (queue1.isEmpty()){
                throw new RuntimeException("栈为空");
            }
            while(queue1.size() != 1){
                queue2.add(queue1.poll());
            }
            int res = queue1.poll();
            queue2.add(res);
            swap();
            return res;
        }

        public int pop(){
            if (queue1.isEmpty()){
                throw new RuntimeException("栈为空");
            }
            while (queue1.size()>1){
                queue2.add(queue1.poll());
            }
            int res = queue1.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = queue2;
            queue2 = queue1;
            queue1 = tmp;
        }
    }

    public static class SactkToQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public SactkToQueue() {
            this.stackPush = new Stack<Integer>();
            this.stackPop = new Stack<Integer>();
        }

        public int poll(){
            if (stackPop.isEmpty() && stackPush.isEmpty()){
                throw new RuntimeException("队列为空");
            }else if(stackPop.empty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek(){
            if (stackPop.isEmpty() && stackPush.isEmpty()){
                throw new RuntimeException("队列为空");
            }else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

}
