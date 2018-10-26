package zuoshengsuanfa.jichuban.QueueAndStack;

import util.ListNode;

/**
 *      毛毛雨     2018/10/23
 * */
public class Code_06_从头到尾打印链表 {

    public static void printListEnd(ListNode root){
        if (root == null){
            return;
        }
        if (root.next == null) {
            return;
        }
        ListNode next = null;
        ListNode cur = null;
        ListNode phead = root;
        ListNode res = null;
        while(phead!=null){
            next = phead.next;
            if (next == null){
                res = phead;
            }
            phead.next = cur;
            cur = phead;
            phead = next;
        }
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static void main(String[] args) {

    }
}
