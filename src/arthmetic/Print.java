package arthmetic;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *      毛毛雨     2018/10/25 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * */
public class Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public  ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
                return res;
         }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            start++;
            if (node.left != null)queue.add(node.left);
            if (node.right != null)queue.add(node.right);
            if (start == end){
                start = 0;
                end = queue.size();
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
