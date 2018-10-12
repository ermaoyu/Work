package arthmetic;

public class EntryNodeOfLoop {
     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
     * */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        boolean flag = false;
        while (p1 != null && p2 != null){
            p1 = p1.next.next;
            p2 = p2.next;
            if (p2 == p1){
                flag = true;
                break;
            }
        }
        if (flag){
            p2 = pHead;

            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
        }else {
            return null;
        }
    }
}
