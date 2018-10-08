package arthmetic;

public class MiddleNode {
    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * */
    public ListNode middleNode(ListNode head) {
        ListNode pr1 = head;
        ListNode pr2 = head;
        while (pr2.next != null && pr2.next.next != null){
            pr1 = pr1.next;
            pr2 = pr2.next.next;
        }
        if (pr2.next != null){
            pr1 = pr1.next;
        }
        return pr1;
    }
}
