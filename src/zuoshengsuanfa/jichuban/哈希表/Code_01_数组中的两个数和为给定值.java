package zuoshengsuanfa.jichuban.哈希表;

import java.util.HashMap;

/**
 *      毛毛雨     2018/10/26
 * */
public class Code_01_数组中的两个数和为给定值 {

    public static int[] hashTable(int[] a,int num){
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(num - a[i])){
                return new int[]{map.get(num - a[i]),i};
            }
            map.put(a[i],i);
        }
    }
}
