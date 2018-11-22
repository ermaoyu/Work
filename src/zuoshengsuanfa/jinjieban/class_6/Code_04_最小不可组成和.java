package zuoshengsuanfa.jinjieban.class_6;


public class Code_04_最小不可组成和 {
    public static int unformedSum1(int[] arr) {
        if (arr == null || arr.length ==0){
            return 1;
        }
        int sum = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i];
            min = Math.min(min,arr[i]);
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0;i < arr.length;i++){
            for (int j = sum;j >= arr[i];j--){//j >= arr[i]防止越界,前面的值已经由dp[j - daa[i]]决定了
                dp[j] = dp[j-arr[i]]?true : dp[j];
            }
        }
        for (int i = min; i < dp.length; i++) {
            if (!dp[i]){
                return i;
            }
        }
        return sum + 1;
    }
}
