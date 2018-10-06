package com.test;

import java.util.LinkedList;

public class MaxWindow {
    public static int[] getMaxWindow(int[] array,int w){
        if (array == null || array.length == 0){
            return null;
        }
        int[] rs = new int[array.length - w + 1];
        int index = 0;
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            while(!qmax.isEmpty()||array[qmax.peekLast()]<=array[i]){//队列中最大的值永远放最前,单调递增的
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w){//窗口大小
                qmax.pollFirst();
            }
            if (i >= w-1){//当行成窗口后输出双向队列的头值
                rs[index++] = array[qmax.peekFirst()];
            }
        }
        return rs;
    }

    public static int getNum(int[] array,int num){
        if(array == null || array.length == 0){
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        while(L < array.length){
            while (R < array.length){
                 while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[R]){
                     qmax.pollLast();
                 }
                 qmax.addLast(R);
                while (!qmin.isEmpty() && array[qmin.peekLast()] >= array[R]){
                    qmin.pollLast();
                }
                qmin.addLast(R);
                if (array[qmax.getFirst()] - array[qmin.getFirst()]>num){
                            break;
                }
                R++;
            }
            if (qmin.peekFirst() == L){
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L){
                qmax.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }
}
