package zuoshengsuanfa.jinjieban.class_3;

import com.test.MorrisTraversal;

import com.test.MorrisTraversal.Node;

/**
 *      毛毛雨     2018/10/23
 *      利用Morris遍历实现二叉树的先序,中序后续遍历
 *      时间复杂度O(N).额外空间复杂度O(1)
 * */
public class Code_01_Morri遍历 {

    //前序遍历
    public static void morrisPre(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        Node mostright = null;
        while(cur!=null){
            mostright = cur.left;
            if (mostright!=null){
                while(mostright.right != null && mostright.right != cur){
                    mostright = mostright.right;
                }
                if (mostright.right == null){
                    System.out.println(cur.value +" ");
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }else if (mostright == cur){
                    mostright.right = null;
                }
            }else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    //中序遍历
    public static void morrisIn(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        Node mostright = null;
        while(cur != null){
            mostright = cur.left;
            if (mostright != null){
                while(mostright != null && mostright.right != null){
                    mostright = mostright.right;
                }
                if (mostright.right == null){
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    cur = mostright.right;
                    mostright.right = null;
                }
            }
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
    }

    //后续遍历
    public static void morrisPos(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        Node mostright = null;
        while(cur != null){
            mostright = node.left;
            if (mostright != null){
                while(mostright.right != null && mostright.right != null){
                    mostright = mostright.right;
                }
                if (mostright.right == null){
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostright.right = null;
                    printEdge(mostright.left);
                }
            }
            cur = cur.right;
        }
        printEdge(node);
    }

    public static void printEdge(Node head){
        Node tail = reverseEdge(head);
        Node cur = tail;
        while(cur != null){
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
    }

    public static  Node reverseEdge(Node from){
        Node pre = null;
        Node next = null;
        while(from != null){
            next = from.right;
            from.right = pre;
            pre = from ;
            from = next;
        }
        return pre;
    }



}
