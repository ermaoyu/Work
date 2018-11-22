package com.test;


/**
 *  毛毛雨
 *  AVL树单旋和双旋
 * */
public class AVL {
    public static class AvlTree{
        int val;
        AvlTree left;   //左孩子
        AvlTree right;  //右孩子
        int height;     //当前节点往下的最大深度
        public AvlTree(int val, AvlTree left, AvlTree right, int height) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        public AvlTree() {
        }
    }

    /**
     *      插入操作有4中case
     *      1.对a节点的左儿子的左子树插入
     *      2.对a节点的左儿子的右子树插入
     *      3.对a节点的右儿子的左子树插入
     *      4.对a节点的右儿子的右子树插入
     * */

    private static int getHeight(AvlTree root){
        return root == null ? 0 : root.height;
    }
    //递归版本
    public static AvlTree insert(int n,AvlTree root){
        if (root == null)return new AvlTree(n,null,null,1);

        if (root.val > n){
            root.left = insert(n,root.left);
        }else if (root.val < n){
            root.right = insert(n,root.right);
        }
        return balance(root);
    }
    private static final int INDEX = 1;

    public static AvlTree balance(AvlTree root){
        if (root == null){
            return root;
        }
        if (getHeight(root.left) - getHeight(root.right) > INDEX){
            if (getHeight(root.left.left) >= getHeight(root.left.right)){
                root = roleftChild(root);//单旋旋转左孩子
            }else {
                root = dobleftChild(root);//双旋旋转左孩子
            }
        }else if (getHeight(root.right) - getHeight(root.left) > INDEX){
            if (getHeight(root.right.right) >= getHeight(root.right.left)){
                root = rorightChild(root);//单旋旋转右孩子
            }else {
                root = dobrightChild(root);//双旋旋转右孩子
            }
        }
        root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
        return root;
    }

    //单旋
    private static AvlTree roleftChild(AvlTree k2){
        AvlTree k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(getHeight(k2.left),getHeight(k2.right)) + 1;
        k1.height = Math.max(getHeight(k1.left),k2.height) + 1;
        return k1;
    }

    private static AvlTree rorightChild(AvlTree k1){
        AvlTree k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(getHeight(k1.left),getHeight(k1.right)) + 1;
        k2.height = Math.max(getHeight(k2.right),k1.height) + 1 ;
        return k2;
    }

    //双旋
    private static AvlTree dobleftChild(AvlTree k3){
        k3.left = rorightChild(k3.left);
        return roleftChild(k3);
    }

    private static AvlTree dobrightChild(AvlTree k3){
        k3.right = roleftChild(k3.right);
        return rorightChild(k3);
    }

    public static void print(AvlTree root){
        if (root == null)return;
        print(root.left);
        System.out.print(" " + root.val);
        print(root.right);
    }

    public static void main(String[] args) {
        AVL test = new AVL();
        AvlTree root = new AvlTree(2,null,null,2);
        root.left = new AvlTree(1,null,null,1);
        root.right = new AvlTree(3,null,null,1);
        int[] nodes = {4,5,6,7,16,15,14,13,12,11,10,8,9};
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("insert: " + nodes[i]);
            test.insert(nodes[i],root);
            test.print(root);
            System.out.println();
        }
    }


}
