package arthmetic;


public class IsBalanced_Solution {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * */
    public boolean IsBalanced_Solution(GetTreeHight.TreeNode root) {
            boolean flag = true;
            int h = judge(root,flag);
            return flag;
    }
    public int judge(GetTreeHight.TreeNode root, boolean flag){

        if (root != null){
            int left = judge(root.left ,flag);
            int right = judge(root.right,flag);
            if (Math.abs(left - right) > 1)flag = false;
            return Math.max(left,right) + 1;
        }
        return 0;

    }
}
