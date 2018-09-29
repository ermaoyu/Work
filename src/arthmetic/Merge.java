package arthmetic;

public class Merge {
    /**
     *输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     * */

     class ListNode {
         int val;
         ListNode next = null;
         ListNode(int val) {
             this.val = val;
         }
     }
     public ListNode merge(ListNode list1,ListNode list2) {
         if (list1 == null) {
             return list2;
         }
         if (list2 == null){
             return list1;
         }
         ListNode head = null;
         ListNode tmp = null;
         while (list1 != null && list2 != null) {
             if (list1.val < list2.val) {
                 if (tmp == null) {
                     tmp = head = list1;
                 }else {
                 head.next = list1;
                 head = head.next;
                 }
                 list1 = list1.next;
             } else {
                 if (tmp == null) {
                     tmp = head = list2;
                 }else {
                     head.next = list2;
                     head = head.next;

                 }
                 list2 = list2.next;
             }
         }
         if (list1 == null) {
             head.next = list2;
         }
         if (list2 == null) {
             head.next = list1;
         }
         return head;
     }

}
