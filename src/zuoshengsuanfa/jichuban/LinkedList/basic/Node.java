package zuoshengsuanfa.jichuban.LinkedList.basic;

/**
 *      毛毛雨     2018/10/18
 */
public class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
    Node() {

    }
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

}
