package arthmetic;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GetTreeHight {

    /**
     * 题目描述
     * 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
     * 输入描述:
     * 输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
     * 下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
     * 输出描述:
     * 输出树的高度，为一个整数
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
    }
    /**
     * 题目描述
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     * */
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //递归
    public  int TreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left,right) + 1;
    }
    //非递归
    public  int TreeDepth2(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        int depth = 0,count = 0,stacknum = 1;
        while(stack.size()!=0){
            count++;
            root = stack.poll();
            if (root.left!=null){
                stack.add(root.left);
            }
            if (root.right!=null){
                stack.add(root.right);
            }
            if (count == stacknum){
                stacknum = stack.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }

}
