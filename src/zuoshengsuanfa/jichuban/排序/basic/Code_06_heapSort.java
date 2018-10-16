package zuoshengsuanfa.jichuban.排序.basic;

import java.util.Arrays;

/**
 *   毛毛雨   2018/10/16  堆排序
 * */

public class Code_06_heapSort {
    /**
     *   调整大根堆
     * */
    public static void buildheap(int[] a,int index){
        while(a[index] > a[(index-1)/2]){
            swap(a,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void heapif(int[] a,int index,int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1< size && a[left] < a[left + 1]? left + 1 : left;
            largest = a[index] > a[largest]? index : largest;
            if (largest == index){
                break;
            }
            swap(a,largest,index);
            index = left;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] a,int index,int i){
        int temp = a[index];
        a[index] = a[i];
        a[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        for(int i = 0;i<nums.length;i++){//循环建堆
            buildheap(nums,i);
        }
        int size = nums.length;
        swap(nums,0,--size);
        //循环出堆的过程
        while(size>0){
            heapif(nums,0,--size);
            swap(nums,0,size);
        }

        System.out.println(Arrays.toString(nums));
    }
}
