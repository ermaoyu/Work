package arthmetic;

public class HasSubtree {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。
     * （ps：我们约定空树不是任意一个树的子结构)
     * */

     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
     }

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null || root1 == null){
            return false;
        }
        boolean flag = false;
        if (root1.val == root2.val){
            flag = hasRLtree(root1,root2);
        }
        if (!flag){
            flag = hasSubtree(root1.left,root2);
        }
        if (!flag){
            flag = hasSubtree(root1.right,root2);
        }
        return flag;
    }

    private boolean hasRLtree(TreeNode root1, TreeNode root2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
         if (root2 == null){
             return true;
         }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
         if (root1 == null){
             return false;
         }
         if (root1.val != root2.val){
             return false;
         }
         return hasRLtree(root1.left,root2.left) && hasRLtree(root1.right,root2.right);
    }
}
