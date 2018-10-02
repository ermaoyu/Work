package arthmetic;

import java.util.Arrays;
import java.util.HashMap;

public class MoreThanHalfNum_Solution {
    /**
     *数组中有一个数字出现的次数超过数组长度的一半，
     * 请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，
     * 因此输出2。如果不存在则输出0。
     * */
    public static int moreThanHalfNum_Solution(int [] array) {
        if (array == null||array.length==0){
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < array.length; i++){
            if (map.containsKey(array[i])){
                int temp = map.get(array[i]);
                if (temp >=array.length/2){
                    return array[i];
                }else {
                    map.put(array[i],++temp);
                }
            }else {
                map.put(array[i], 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNum_Solution(array));
    }
}
