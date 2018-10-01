package arthmetic;

import java.util.HashMap;

public class FindFirstCommonNode {
    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * */
     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode curr1 = pHead1;
        ListNode curr2 = pHead2;

        HashMap<ListNode,Integer> map = new HashMap<>();

        while(curr1!=null){
            map.put(curr1,null);
            curr1 = curr1.next;
        }
        while(curr2!=null){
            if (map.containsKey(curr2)){
                return curr2;
            }
            curr2 = curr2.next;
        }
        return null;

    }
}
