package zuoshengsuanfa.jinjieban.class_2;

/**
 *      毛毛雨     2018/10/25  时间复杂度O(row4)
 *      链接：https://www.nowcoder.com/questionTerminal/a5a0b05f0505406ca837a3a76a5419b3
 * 来源：牛客网
 *
 * 已知矩阵的大小定义为矩阵中所有元素的和。给定一个矩阵，
 * 你的任务是找到最大的非空(大小至少是1 * 1)子矩阵。
 * 比如，如下4 * 4的矩阵 0 -2 -7 0 9 2 -6 2 -4 1 -4 1 -1 8 0 -2
 * 的最大子矩阵是 9 2 -4 1 -1 8 这个子矩阵的大小是15。
 * */
public class Code_07_作业_最大子矩阵 {
    public static  int sort(int[] a,int row ,int clu){
        if (a.length == 0 || a == null){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            int[] high = new int[clu];
            for (int k = i; k < row; k++) {
                for (int j = 0; j < clu; j++) {
                    high[j] += a[k * row + j];
                }
                max = Math.max(getMaxt(high), max);
            }
        }
        return max;
    }

    //一维数组连续最大和
    public static int getMaxt(int[] a){
        if (a.length == 0 || a == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length ; i++) {
            sum += a[i];
            max = Math.max(max,sum);
            if (sum < 0)sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {0,-2 ,-7 ,0 ,9 ,2 ,-6, 2 ,-4, 1, -4, 1, -1, 8 ,0 ,-2};
        System.out.println(sort(a,4,4));
    }
}
