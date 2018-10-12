package arthmetic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeandDeserialize {
    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     * */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    String Serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        StringBuffer str = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();

            if (root != null){
                stack.push(root.right);
                stack.push(root.left);
                str.append(root.val+"_");
            }else{
                str.append("#_");
            }
        }
        return str.toString();
    }
    TreeNode Deserialize(String str) {
        String[] data = str.split("#");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0;i < data.length;i++){
            queue.offer(data[i]);
        }
        return reTree(queue);
    }
    public TreeNode reTree(Queue<String> queue){
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = reTree(queue);
        node.right = reTree(queue);
        return node;
    }
}
