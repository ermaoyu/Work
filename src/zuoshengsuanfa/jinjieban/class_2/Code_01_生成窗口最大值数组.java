package zuoshengsuanfa.jinjieban.class_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *      毛毛雨     2018/10/21
 * */
public class Code_01_生成窗口最大值数组 {

    public static int[] getWindow(int[] a,int w){
        if (a.length == 0 || a == null || a.length < w){
            return null;
        }
        int[] num = new int[a.length - w + 1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0;i < a.length;i++){
            while (!queue.isEmpty() && a[queue.peekLast()]<=a[i]){
                queue.pollLast();
            }
            queue.addLast(i);

            if (queue.peekFirst() == i - w){//如果队列里的第一个数到更新值时,出队列
                queue.pollFirst();
            }
            if (i >= w -1 ){//判断窗口中的值是否到了最大
                num[index++] = a[queue.peekFirst()];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] a ={4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(getWindow(a,3)));
    }

}
