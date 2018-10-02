package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreecovStr {
    /**
     * 二叉树的序列化和反序列化
     * */
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //先序序列化(基于递归的)
    public static String serialByPre(Node head){
        if(head == null){
            return "#_";
        }
        String rs = head.value + "_";
        rs += serialByPre(head.left);
        rs += serialByPre(head.right);
        return rs;
    }
    //基于先序的反序列化
    public static  Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i != values.length ; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return  head;
    }

    //先序序列化(基于非递归)
    public static String serialByPreNo(Node head){
        if (head == null){
            return  null;
        }
        String rs = "";
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            if (head != null){
                rs += head.value + "_";
                stack.push(head.right);
                stack.push(head.left);
            }else {
                rs += "#_";
            }
        }
       return rs;
    }



    //基于先序的反序列化(非递归)
    public static  Node reconByPreStringNo(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i != values.length ; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrderNo(queue);
    }
  public static Node reconPreOrderNo(Queue<String> queue){
//        if (queue.isEmpty()){
//            return  null;
//        }
//        Node head = null;
//        while(!queue.isEmpty()){
//            String str = queue.poll();
//            if (!str.equals("#"));{
//                head = new Node(Integer.valueOf(str));
//                str = queue .poll();
//                if (!str.equals("#")){
//                    head.left = new
//                }
//            }
//        }
//        Node head = new Node(Integer.valueOf(value));
//        head.left = reconPreOrder(queue);
//        head.right = reconPreOrder(queue);
        return  null;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);
        System.out.println(serialByPre(t1));
        System.out.println(serialByPreNo(t1));
    }
 }