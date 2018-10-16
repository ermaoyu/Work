package zuoshengsuanfa.jinjieban.class_1;

/**
 *   毛毛雨  2018/10/16  判断一棵数是否另一棵的子树
 * */
public class Code_03_KMP_SubtreeEquals {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static  boolean isSubtree(Node t1,Node t2){
        String t1str = serialTree(t1);
        String t2str = serialTree(t2);
        return getIndexOf(t1str,t2str)!=-1;
    }

    public static String serialTree(Node tree){
        if (tree == null){
            return "#";
        }
        String res = tree.value+"_";
        res +=serialTree(tree.left);
        res +=serialTree(tree.right);
        return res;
    }

    public static int getIndexOf(String s,String m){
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int [] next = getNext(str2);
        int x = 0;
        int cn = 0;
        while(x < str1.length && cn < str2.length){
            if (str1[x] == str2[cn]){
                ++x;
                ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                ++x;
            }
        }
        return cn == str2.length? x - cn : -1;
    }
    /**
     * next[]数组求解
     * */
    private static int[] getNext(char[] str2) {
        if(str2.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while(i < next.length){
            if (str2[i-1] == str2[cn]){
                next[i++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(isSubtree(t1, t2));

    }
}
