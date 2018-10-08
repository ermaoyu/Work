package arthmetic;

public class Convert {
    /**
     *输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向
     * */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private TreeNode pr1 = null;
    private TreeNode pr2 = null;
    public TreeNode convert(TreeNode pRootOfTree) {
            visit(pRootOfTree);
            return pr2;
   }
   public void visit(TreeNode pRootOfTree){
       if (pRootOfTree == null){
           return ;
       }
       convert(pRootOfTree.left);
       if (pr1 == null){
           pr1 = pRootOfTree;
           pr2 = pRootOfTree;
       }else {
           pr1.right = pRootOfTree;
           pRootOfTree.left = pr1;
           pr1 = pRootOfTree;
       }
       convert(pRootOfTree.right);
   }
}
