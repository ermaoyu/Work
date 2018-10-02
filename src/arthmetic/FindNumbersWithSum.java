package arthmetic;

import java.util.ArrayList;
import java.util.HashMap;

public class FindNumbersWithSum {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 输出描述:
     * 对应每个测试案例，输出两个数，小的先输出
     * */
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return list;
        }
        int tmp = 0, pre = 0;
        int[] min = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(sum - array[i])) {
                int num = map.get(sum - array[i]);
                tmp = num * array[i];
                if(pre == 0){
                    pre = tmp;
                }
                if (tmp <= pre) {
                    pre = tmp;
                    min[0] = num < array[i] ? num : array[i];
                    min[1] = num > array[i] ? num : array[i];
                }
            } else {
                map.put(array[i], array[i]);
            }
        }
        if (min[0] ==0 && min[1] == 0){
            return list;
        }else {
            list.add(min[0]);
            list.add(min[1]);
        }
        return list;
    }

    public static void main(String[] args) {
        int [] array = {1,2,4,7,11,16};
        System.out.println(findNumbersWithSum(array,10).toString());
    }
}
