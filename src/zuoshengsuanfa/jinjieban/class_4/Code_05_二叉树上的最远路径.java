package zuoshengsuanfa.jinjieban.class_4;

public class Code_05_二叉树上的最远路径 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType{
        public int maxDis;
        public int height;
        public ReturnType(int maxDis, int height) {
            this.maxDis = maxDis;
            this.height = height;
        }
    }

    public static ReturnType process(Node x){
        if (x == null){
            return new ReturnType(0,0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        int maxDis = Math.max(leftData.maxDis,rightData.maxDis);
        int height = Math.max(leftData.height,rightData.height) + 1;
        maxDis = Math.max(maxDis,leftData.height+rightData.height + 1);
        return new ReturnType(maxDis,height);
    }


}
