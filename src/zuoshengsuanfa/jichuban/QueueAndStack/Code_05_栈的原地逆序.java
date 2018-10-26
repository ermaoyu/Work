package zuoshengsuanfa.jichuban.QueueAndStack;

import util.ListNode;

/**
 *      毛毛雨     2018/10/23
 * */
public class Code_05_栈的原地逆序 {

    public static ListNode reverse(ListNode root){
        if (root == null){
            return root;
        }
        ListNode next = null;
        ListNode cur = null;
        ListNode phead = root;
        ListNode res = phead;
        while(phead != null){
            next = phead.next;
            phead.next = cur;
            cur = phead;
            phead = next;
        }
        return res;
    }
}
