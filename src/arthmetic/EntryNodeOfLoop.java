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
        if (pHead == null ){
            return pHead;
        }
        if(pHead.next == null){
            return pHead.next;
        }
        //先判断是否有环
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        boolean flag = false;
        while (p1 != null && p2 != null){
            p1 = p1.next.next;
            p2 = p2.next;
            if (p2 == p1){
                break;//有环
            }
            if(p1.next == null){
                return p1.next;
            }
        }
        p1 = pHead.next;
        int count = 1;
        while (p1 != p2){
            count++;
            p1 = p1.next;
        }
        p1 = pHead;
        p2 = pHead;
        for (int i = 0; i < count ;i++ ){
            p1 = p1.next;
        }
        while(p2!=p1){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
