package arthmetic;

public class RemoveNthFromEnd {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pr1 = head;
        ListNode pr2 = head;
        for (int i = 1;i <= n+1  ;i++){
            pr2 = pr2.next;
        }
        while (pr2 !=null){
            pr1 = pr1.next;
            pr2 = pr2.next;
        }
        pr1.next = pr1.next.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode root = removeNthFromEnd(head,2);
        System.out.println(root.val);
    }
}
