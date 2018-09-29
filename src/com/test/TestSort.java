package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSort {
    public static void insertSort(int a[]) {//直接插入排序法
        if (a != null) {
            for (int i = 0; i < a.length - 1; i++) {
                int temp = a[i + 1];
                int j = i;
                while (j > -1 && a[j] > temp) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp;
            }
        }
    }

    public static void selectSort(int a[]) {//选择排序法
        int i, j;
        int flag = 0;
        int temp = 0;
        int n = a.length;
        for (i = 0; i < n - 1; i++) {
            flag = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[flag]) {
                    flag = j;
                }
                if (flag != i) {
                    temp = a[flag];
                    a[flag] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void quickSort(int a[], int low, int high) {//快速排序法
        int i, j, index;
        if (low > high) return;//找到递归算法的出口
        i = low;
        j = high;
        index = a[i];// 用子表的第一个记录做基准
        while (i < j) {//从表的两端交替向中间扫描
            while (i < j && a[j] >= index)j--;//从右往左找到第一个小于key的数
            if (i < j)a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)i++;// 从左往右找到第一个大于key的数
            if (i < j) a[j--] = a[i];// 用比基准大的记录替换高位记录
        }
        a[i] = index;
        quickSort(a, low, i - 1);
        quickSort(a, i+1, high);
    }





    public static void main(String[] args) {
        int a[] = {3,5,1,6,9,7,2};
//        TestSort.insertSort(a);
//        for (int i = 0;i<a.length;i++){
//            System.out.print(a[i]);
//        }
//        TestSort.selectSort(a);
//        for (int i = 0;i<a.length;i++){
//            System.out.print(a[i]+" ");
//        }

        TestSort.quickSort(a,0,a.length-1);
        for (int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

    }
}
