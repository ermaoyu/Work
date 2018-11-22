package zuoshengsuanfa.jichuban.Tree.basic;

public class isBanlance {
    public boolean isBanlance(TreeNode root){
        if (root == null)return true;
        int left = getHeight.getH(root.left);
        int right = getHeight.getH(root.right);
        if (Math.abs(left - right) > 1){
            return false;
        }
        return isBanlance(root.left) && isBanlance(root.right);
    }
}
