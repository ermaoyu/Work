package zuoshengsuanfa.jinjieban.class_5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *      毛毛雨     2018/11/1
 *      一次删除两个数,剩下来的可能是超过一半的
 *      但是超过一半的数一定会被剩下
 *      再判断这个剩下的数出现次数
 *
 *      进阶给定一个K
 *      打印出现次数大于N/K
 * */
public class Code_07找出数组中大于一半的数 {
    public static void printHalfMajor(int[] a){
        int index = 0;
        int time = 0;
        for (int i = 0; i < a.length; i++) {
            if (time == 0){
                index = a[i];
                time = 1;
            }else if (index == a[i]){
                time++;
            }else {
                time--;
            }
        }
        if (time == 0){
            System.out.println("不存在!!!");
            return;
        }
        time = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == index){
                time++;
            }
        }
        if (time > a.length/2){
            System.out.println(index);
        }else {
            System.out.println("不存在");
        }
    }

    public static void printKMajor(int[] a,int k){
        if(k < 2){
            System.out.println("invalid");
            return;
        }
        HashMap<Integer,Integer> index = new HashMap<Integer,Integer>();
        for (int i = 0;i < a.length;i++){
            if (index.containsKey(a[i])){
                index.put(a[i],index.get(a[i]) + 1);
            }else {//当前数不在后选表中
                if (index.size() == k -1){
                    allIndexMinuOne(index);
                }else {
                    index.put(a[i],1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(a, index);
        boolean hasPrint = false;
        for (Map.Entry<Integer, Integer> set : index.entrySet()) {
            Integer key = set.getKey();
            if (reals.get(key) > a.length / k) {
                hasPrint = true;
                System.out.print(key + " ");
            }
        }
        System.out.println(hasPrint ? "" : "no such number.");
    }
    public static HashMap<Integer, Integer> getReals(int[] arr,
                                                     HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<Integer, Integer>();
        for (int i = 0; i != arr.length; i++) {
            int curNum = arr[i];
            if (cands.containsKey(curNum)) {
                if (reals.containsKey(curNum)) {
                    reals.put(curNum, reals.get(curNum) + 1);
                } else {
                    reals.put(curNum, 1);
                }
            }
        }
        return reals;
    }

    public static void allIndexMinuOne(HashMap<Integer, Integer> map){
        List<Integer> remveList = new LinkedList<Integer>();
        for (Map.Entry<Integer, Integer> set : map.entrySet()){
            Integer key = set.getKey();
            Integer value = set.getValue();
            if (value == 1){
                remveList.add(key);
            }
            map.put(key,value -1 );
        }
        for (Integer removeKey : remveList) {
            map.remove(removeKey);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 2, 1 };
        printHalfMajor(arr);

        printKMajor(arr,4);
    }
}
