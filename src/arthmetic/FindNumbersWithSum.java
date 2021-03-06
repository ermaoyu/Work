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

    /***
     *      双指针,额外空间复杂度O(1)
     */
     public static ArrayList<Integer> findNumbersWithSum1(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return list;
        }
        int i = 0;
        int j = array.length - 1;
        int minNum1 = 0;
        int minNum2 = 0;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        while(i < j) {
            temp = array[i] + array[j];
            if (temp < sum) i++;
            else if (temp > sum) j--;
            else {
                int index = array[i] * array[j];
                if (index < min) {
                    min = index;
                    minNum1 = array[i];
                    minNum2 = array[j];
                }
                i++;
            }
        }
        if (minNum1 == 0 && minNum2 == 0){
            return list;
        }
        list.add(minNum1);
        list.add(minNum2);
        return list;
     }

    public static void main(String[] args) {
        int [] array = {1,2,4,6,7,16};
        System.out.println(findNumbersWithSum1(array,8).toString());
    }
}
