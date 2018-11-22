package arthmetic;

/**
 *  请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * */
public class isSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null){
            return true;
        }
        return judge(pRoot.left,pRoot.right);
    }
    boolean judge(TreeNode left,TreeNode right){
        if (left == null)return right ==null;
        if (right == null)return left == null ;
        if (left.val != right.val)return false;
        return judge(left.left,right.right)&&judge(left.right,right.left);
    }


}
