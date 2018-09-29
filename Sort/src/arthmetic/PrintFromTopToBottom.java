package arthmetic;

import java.util.ArrayList;

public class PrintFromTopToBottom {
    /**
     *从上往下打印出二叉树的每个节点，同层节点从左至右打印
     * */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if (root == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0){
            TreeNode tmp = queue.remove(0);
            if (tmp.left != null){
                queue.add(tmp.left);
            }
            if (tmp.right != null){
                queue.add(tmp.right);
            }
            list.add(tmp.val);
        }

        return list;
    }
}
