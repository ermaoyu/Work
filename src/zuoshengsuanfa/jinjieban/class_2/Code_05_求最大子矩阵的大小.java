package zuoshengsuanfa.jinjieban.class_2;

import java.util.Stack;

/**
 *      毛毛雨     2018/10/22
 * */
public class Code_05_求最大子矩阵的大小 {
    /**
     *      单调栈思想:
     *          {3,2,4,5,6}
     *          栈中从上到下是 大->小排序的
     * */

    public static int maxRecSize(int[][] map){
        if (map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int max = 0;
        int[] high = new int[map[0].length];
        for (int i = 0;i<map.length;i++){
            for (int j = 0;j<map[0].length;j++){
                high[j] = map[i][j] == 0?0:high[j]+1;
            }
            max = Math.max(maxRecFromBottom(high),max);
        }
        return max;
    }

    public static int maxRecFromBottom(int[] high){
        if (high == null || high.length == 0){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<high.length;i++){
            while (!stack.isEmpty() && high[i] <= high[stack.peek()]){
                int j = stack.pop();//左边比他大的高,有几个J就相同与num[j]*high[i]
                int k = stack.isEmpty()? -1 : stack.peek();//最左边边界,
                int cur = (i - k - 1) * high[j];//(i - k -2) == num[j] + 1
                max = Math.max(max,cur);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()? -1 : stack.peek();//相同与中间是否有比他大的高
            int cur = (high.length - k -1)* high[j];
            max = Math.max(max,cur);
        }
        return max;
    }

}
