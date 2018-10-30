package zuoshengsuanfa.jinjieban.class_4;

public class Code_04_最大二叉搜索树的大小 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType{
        public int maxSize;
        public boolean isWholeBST;
        public int max;
        public int min;
        public ReturnType(int maxSize, boolean isWholeBST, int max, int min) {
            this.maxSize = maxSize;
            this.isWholeBST = isWholeBST;
            this.max = max;
            this.min = min;
        }
    }

    public static ReturnType process(Node x){
        if (x == null){
            return new ReturnType(0,true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        int max = Math.max(Math.max(leftData.max,rightData.max),x.value);
        int min = Math.min(Math.min(leftData.min,rightData.min),x.value);
        int maxSize = Math.max(leftData.maxSize,rightData.maxSize);
        boolean isWholeBST = false;

        if (leftData.isWholeBST
                && rightData.isWholeBST
                && leftData.max < x.value
                && rightData.min > x.value){
            maxSize = leftData.maxSize + rightData.maxSize + 1;
            isWholeBST = true;
        }

        return new ReturnType(maxSize,isWholeBST,max,min);
    }




}
