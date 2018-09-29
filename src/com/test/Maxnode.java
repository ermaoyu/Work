package com.test;

public class Maxnode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static  int nodeNum(Node head){
        if (head == null){
            return 0;
        }
        return  bs(head,1,mostLeftLevel(head,1));
    }

    public static int bs(Node head,int level,int h){
        if ( level == h){
            return 1;
        }
        if (mostLeftLevel(head.right,level+1) == h){//判断当前节点的右子树的最左子树的高度是否为h
            return   (1 << (h-level)) + bs(head.right,level+1,h);
        }else {
            return (1 << (h - level -1)) + bs(head.left,level + 1,h);
        }
    }

    public  static int mostLeftLevel(Node head,int level){//求树的高度函数
        while(head != null){
            level++;
            head = head.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }
}
