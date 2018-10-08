package arthmetic;

public class DeleteNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode deleteNode(ListNode node,int k) {
        ListNode root = node;
        ListNode cur = root;
        for (int i = 1; i < k ; i++) {
            cur = cur.next;
        }
        cur = cur.next.next;
        return root;
    }
}
