package arthmetic;

public class JumpFloor {
    /**
     *题目描述
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * */
    public static int jumpFloor(int target) {
        long sum = 0;
        if (target == 0) {
            return 0;
        }
        if (target > 0) {
            for (int x = 0; x <= target; x++) {
                for (int y = 0; y <= target; y++) {
                    if ((x + 2 * y) == target) {
                        long a =1,b=1,c=1;
                        for (int i=1;i<=x+y;i++){
                             a *= i;
                        }
                        for (int i=1;i<=x;i++){
                            b *= i;
                        }
                        for (int i = 1;i<=y;i++){
                            c *=i;
                        }
                        sum =sum + a/(b*c);
                    }
                }
            }
        }
        return (int)sum;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(6));
    }
}
