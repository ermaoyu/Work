package arthmetic;

public class VerifySquenceOfBST {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     * */
    public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        int size = sequence.length-1;
        int i = 0;
        while(size > 0){
            while(sequence[i]<sequence[size])i++;
            while (sequence[i]>sequence[size])i++;
            if (i<size) {
                return false;
            }
            i = 0;
            size--;
        }
        return  true;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        System.out.println(verifySquenceOfBST(a));
    }

}
