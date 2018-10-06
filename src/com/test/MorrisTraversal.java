package com.test;

public class MorrisTraversal {
    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static void morrisIn(Node head){
        if (head == null){
            return;
        }
        Node cur = head;
        Node morstright = null;
        while (cur != null){
            morstright = cur.left;//找到cur左孩子的的最右节点
            if (morstright != null){
                while(morstright.right != null && morstright.right != cur){
                    morstright = morstright.right;
                }
                if (morstright.right == null){
                    morstright.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    morstright.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }
}
