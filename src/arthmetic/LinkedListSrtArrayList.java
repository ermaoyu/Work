package arthmetic;

import java.util.ArrayList;
import java.util.Stack;

public class LinkedListSrtArrayList {
    /**
     *输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     * */
    public class ListNode {
       int val;
       ListNode next = null;
       ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list =  new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (listNode==null){
            return list;
        }
        while (listNode != null){
            stack.push(listNode.val);
            listNode =listNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
