package zuoshengsuanfa.jichuban.Tree;

import zuoshengsuanfa.jichuban.Tree.basic.TreeNode;

public class 判断平衡二叉树 {
    public class ReturnType{
        int deep;
        boolean isBal;
        public ReturnType(int deep, boolean isBal) {
            this.deep = deep;
            this.isBal = isBal;
        }
    }

    public boolean isBalance(TreeNode root){
        return process(root).isBal;
    }

    public ReturnType process(TreeNode root){
        if (root == null) return  new ReturnType(0,true);

        ReturnType left = process(root.left);
        ReturnType right = process(root.right);
        boolean isBal = false;
        if (Math.abs(left.deep - right.deep) <= 1 && left.isBal&& right.isBal){
            isBal = true;
        }
        return new ReturnType(Math.max(left.deep,right.deep)+1,isBal);
    }
}
