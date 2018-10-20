package zuoshengsuanfa.jichuban.排序;

/**
 *      毛毛雨     2018/10/17
 *    从左边起，不断更新最大值，找到A【i】值比最大值大时替换最大值，比最大值小时更新下标记录为r。
 *    从右边起，不断更新最小值，找到A【i】值比最小值小时替换最小值，比最小值大时更新下标记录为r。
 * */
public class Code_07_需要排序的最短子序列 {
        public static int shortLength(int[] a){
            if (a.length <=1)return 0;
            if (a.length == 2)return a[0] >a [1]? 2:0;
            int i = 0;
            int j = a.length - 1;
            int left = 0;
            int right = 0;
            for (;i<a.length-1;i++){
                if (a[i] < a[i+1]){
                    left = i;
                    break;
                }
            }
            if (i == a.length-1)return 0;
            for (;j>0;j--){
                if (a[j] < a[j-1]){
                    right = j;
                    break;
                }
            }
            return right - left ;


        }

    public static void main(String[] args) {
        int []a = {1,5,3};
        System.out.println(shortLength(a));
    }

}
