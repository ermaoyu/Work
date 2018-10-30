package zuoshengsuanfa.jinjieban.class_4;

import java.util.List;

public class Code_03_多叉树的最大快乐值 {

    public static class Node{
        public int happy;
        public List<Node> nexts;
    }

    public static class  ReturnType{
        public int lai_max_happy;
        public int bu_max_happy;

        public ReturnType(int lai_max_happy, int bu_max_happy) {
            this.lai_max_happy = lai_max_happy;
            this.bu_max_happy = bu_max_happy;
        }
    }

    public static int maxhappy(Node x){
        ReturnType data = process(x);
        return Math.max(data.bu_max_happy,data.lai_max_happy);
    }

    public static ReturnType process(Node x) {
        if (x.nexts.isEmpty()){
            return new ReturnType(x.happy,0);
        }
        int lai = x.happy;
        int bu = 0;
        for (Node next:x.nexts) {
            ReturnType nextData = process(next);
            lai += nextData.bu_max_happy;
            bu  += Math.max(nextData.bu_max_happy,nextData.lai_max_happy);
        }
        return new ReturnType(lai,bu);


    }
}
