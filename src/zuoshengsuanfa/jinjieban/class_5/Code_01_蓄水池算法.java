package zuoshengsuanfa.jinjieban.class_5;

import java.util.LinkedHashMap;

/**
 *      毛毛雨     2018/11/2
 *
 * */
public class Code_01_蓄水池算法 {
    public static int rand(int max){
        return (int)(Math.random() * max);
    }
    public static int[] getKNumsRand(int k,int max){
        if (max < 1 || k < 1){
            return null;
        }
        int[] res = new int[Math.min(k,max)];
        for (int i = 0;i != res.length;i++){
            res[i] = i + 1;
        }
        for (int i = k + 1;i < max + 1;i++){
         if (rand(i) <= k){
             res[rand(k) - 1] = i;
         }
        }
        return res;
    }
}
