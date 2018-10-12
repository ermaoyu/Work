package arthmetic;

public class GetNext {
    /**
     *给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * */
     class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode getNext(TreeLinkNode pNode){
            if (pNode == null){
                return pNode;
            }
            if (pNode.right != null){
                return getleft(pNode.right);
            }else {
                TreeLinkNode parent = pNode.next;
                while (parent != null && parent.left != pNode){
                    pNode = parent;
                    parent = pNode.next;
                }
                return parent;
            }
    }

    public TreeLinkNode getleft(TreeLinkNode root){
        while (root.left != null){
            root = root.left;
        }
         return root;
    }
}
