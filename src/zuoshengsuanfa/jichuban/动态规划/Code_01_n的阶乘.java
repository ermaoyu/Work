package zuoshengsuanfa.jichuban.动态规划;

/**
 *      毛毛雨     2018/10/31
 * */
public class Code_01_n的阶乘 {
    public static long getFact(int n){
        if (n == 1){
            return 1L;
        }
        return (long) n * getFact(n-1);
    }

    public static long getFact2(int n){
        long res = 1L;
        for (int i = 0; i <=n ; i++) {
            res *= i;
        }
        return res;
    }
}
