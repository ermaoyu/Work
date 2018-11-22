package zuoshengsuanfa.jichuban.Tree.basic;

public class getHeight {

    public static  int getH(TreeNode root){
        if (root == null)return 0;
        int left = getH(root.left);
        int right = getH(root.right);
        return (left > right ? left : right) + 1;
    }
}
