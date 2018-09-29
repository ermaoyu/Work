package arthmetic;

public class Mirror {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 输入描述:
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     * */
     class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
             this.val = val;

         }
     }
    public  void mirror(TreeNode root) {
         if (root == null)return;
         if (root.left == null && root.right == null){
             return;
         }
         TreeNode tmp = null;
         tmp = root.left;
         root.left = root.right;
         root.right = tmp;

         if(root.right != null){
             mirror(root.right);
         }
         if (root.left != null){
             mirror(root.left);
         }
    }
}
