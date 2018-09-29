package arthmetic;

import java.util.ArrayList;

public class GetLeastNumbers_Solution {
    /**
     * 题目描述
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
     * */
    public static ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {

            if (k>input.length)return null;
            ArrayList<Integer> list = new ArrayList<>();
            //快排思想,先快排把数组排序好时间复杂度O(nlogn);
            int low = 0;
            int high = input.length - 1;
            fastSort(input,low,high);


            if (input ==null || input.length <2){
                return list;
            }
            //堆排序思想,先把数组排成一个大顶堆,让后输出数组,
            for (int i = 0 ;i<input.length;i++){//建立一个大根堆
                buildHeapSort(input,i);
            }
            int size = input.length;
            swap(input,0,--size);
            while (size>0){
                heapify(input,0,size);
                swap(input,0,--size);
            }
             for (int i =0;i<k;i++){
            list.add(input[i]);
            System.out.println(input[i]);
            }
            return list;


    }

    private static void heapify(int[] a, int index, int size) {
        int left = index * 2 + 1;
        while(left < size){
            int lagest  = left + 1< size && a[left] > a[left + 1] ? left : left + 1;
            lagest = a[index] > a[lagest] ? index : lagest;
            if (index == lagest)break;
            swap(a,lagest,index);
            index = lagest;
            left = index * 2 + 1;
        }
    }

    private static void buildHeapSort(int[] a, int index) {
        while(a[index]>a[(index-1)/2]){
            swap(a,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void swap(int[] a, int index, int i) {
        int temp = a[index];
        a[index] = a[i];
        a[i] = temp;
    }

    public static void fastSort(int [] a,int low , int high){
        if(low>high)return;
        int i,j;
        i = low;
        j = high;
        int index = a[i];
        while(i<j){
            while (i<j&&a[j]<index)j--;
            if(i<j)a[i++] = a[j];
            while (i<j&&a[i]>index)i++;
            if (i<j)a[j--] = a[i];
        }
        a[i] = index;
        fastSort(a,low,i-1);
        fastSort(a,i+1,high);
    }
    public static void main(String[] args) {
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        getLeastNumbers_Solution(a,4);
        for (int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
