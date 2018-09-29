package com.test;

public class HeapSort {
    public static void heapSort(int [] a){
        if (a ==null || a.length <2){
            return ;
        }
        //开始排序
        for (int i=0;i<a.length;i++){
            //循环建堆
            heepInsert(a,i);
        }
        int size = a.length;
        swap(a,0,--size);//把根节点的值与最后一个节点的值互换
        while(size>0){
            heapify(a,0,size);//把最后一个节点的值移除,然后数组长度-1,重新排这个大根堆(假象);
            swap(a,0,--size);
        }

    }

    private static void heapify(int[] a, int index, int heapsize) {//这时候根节点已经被移除了
        int left = index*2+1;
        while(left<heapsize){
                int lagerst = left + 1 < heapsize && a[left + 1] > a[left] ? left + 1 : left ;//
                lagerst = a[lagerst] > a[index] ? lagerst : index ;//
                if (lagerst == index){
                    break ;
                }
                swap(a,lagerst,index);
                index = lagerst;//从新定义父节点
                left = index*2+1;//比较下一个子节点和父节点的大小
        }
    }

    private static void heepInsert(int[] a, int index) {
        while(a[index]>a[(index-1)/2]){
            //如果插入的节点比父节点大,就把父节点和此节点交换
            swap(a,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }



    public static void main(String[] args) {
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        heapSort(a);
        for (int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
