package com.test;

import java.util.Stack;

public class TreeOutputway {

    /**
     * 自定义二叉数
     * */
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
    /**
     * 采用递归的方式遍历二叉数
     * */

    //前序遍历
    public static void preOut(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value + " " );
        preOut(head.left);
        preOut(head.right);
    }

    //中序遍历
    public static void inOut(Node head){
        if (head == null){
            return;
        }
        inOut(head.left);
        System.out.println(head.value + " " );
        inOut(head.right);
    }

    //后序遍历
    public static void posOut(Node head){
        if (head == null){
            return;
        }
        posOut(head.left);
        posOut(head.right);
        System.out.println(head.value + " " );
    }

    /**
     * 非递归的方式遍历二叉树
     * */

    //前序遍历
    public static void preOutre(Node head){
        System.out.print("pre-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

     //中序遍历
    public static void inOutre(Node head){
        System.out.print("in-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {//当上一个节点左子树为空时,令当前栈顶出栈,head节点等于栈顶,然后打印当前结点
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;//再判断右子树是否为空
                }
            }
        }
        System.out.println();
    }

    //后序遍历
    public static void posOutre(Node head){
        System.out.print("pos-order: ");
       if( head != null){
           Stack<Node> s1 = new Stack<>();
           Stack<Node> s2 = new Stack<>();
           s1.push(head);
           while(!s1.isEmpty()){
               head = s1.pop();
               s2.push(head);
               if (head.left != null){
                   s1.push(head.left);
               }
               if (head.right != null){
                   s1.push(head.right);
               }
           }
           while (!s2.isEmpty()){
               System.out.print(s2.pop().value + " ");
           }
       }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.println("pre-order: ");
        preOut(head);
        System.out.println();
        System.out.println("in-order: ");
        inOut(head);
        System.out.println();
        System.out.println("pos-order: ");
        posOut(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOutre(head);
        inOutre(head);
        posOutre(head);
    }
}
