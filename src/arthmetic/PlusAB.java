package arthmetic;

public class PlusAB {
    /**题目描述
     有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，
     也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
     给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
     测试样例：
     {1,2,3},{3,2,1}
     返回：{4,4,4}
     *
     * */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode rshead = new ListNode(-1);
        ListNode rs = rshead;
        ListNode A = a;
        ListNode B = b;
        int sum = 0;
        while(A != null || B != null || sum != 0){
            if (A != null){
                sum += A.val;
                A = A.next;
            }
            if (B != null){
                sum += B.val;
                B = B.next;
            }
            rs.next = new ListNode(sum % 10);
            sum /= 10;
            rs = rs.next;
        }
        return rshead.next;
    }

}
