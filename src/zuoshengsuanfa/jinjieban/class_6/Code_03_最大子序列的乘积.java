package zuoshengsuanfa.jinjieban.class_6;

/**
 *      毛毛雨     2018/11/2
 *      给定一个double类型的数组arr，其中的元素可正、可负、可0，
 *      返回子数组累乘的最大乘积。例如，arr=[-2.5，4，0，3，0.5，8，-1]，
 *      子数组[3，0.5，8] 累乘可以获得最大的乘积12，所以返回12。
 * */
public class Code_03_最大子序列的乘积 {
    //以某一个数结尾的最大乘积
    public static double maxProduct(double[] a){
        if (a == null || a.length == 0){
            return 0;
        }
        double max = a[0];
        double min = a[0];
        double res = a[0];
        double maxEnd = 0;
        double minEnd = 0;
        for (int i = 1; i < a.length; i++) {//因为有负数所以要求最小值
            maxEnd = max * a[i];
            minEnd = min * a[i];
            max = Math.max(Math.max(maxEnd,minEnd),a[i]);
            min = Math.min(Math.min(maxEnd,minEnd),a[i]);
            res = Math.max(res,max);
        }
        return res;
    }

}
