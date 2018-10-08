package arthmetic;

import java.util.Stack;

public class IsPalindrome {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 请编写一个函数，检查链表是否为回文。
     *
     * 给定一个链表ListNode* pHead，请返回一个bool，
     * 代表链表是否为回文。
     *
     * 测试样例：
     * {1,2,3,2,1}
     * 返回：true
     * {1,2,3,2,3}
     * 返回：false
     * */
    public boolean isPalindrome(ListNode pHead) {
        Stack<Integer> stack = new Stack<>();
        ListNode pr1 = pHead;
        ListNode pr2 = pHead;
        stack.push(pr1.val);
        while (pr2.next != null && pr2.next.next != null){
            pr1 = pr1.next;
            stack.push(pr1.val);
            pr2 = pr2.next.next;
        }
        if (pr2.next == null){//pHead长度为奇数
            stack.pop();
        }
        pr1 = pr1.next;
        while( !stack.isEmpty()){
            if (stack.peek() != pr1.val){
                break;
            }
            pr1 = pr1.next;
            stack.pop();
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
