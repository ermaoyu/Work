package zuoshengsuanfa.jichuban.排序;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *    毛毛雨   2018/10/17
 *    有错误
 * */
public class Code_03_小范围排序 {
    //数组几乎有序,每个元素次数不超过k,k对于数组长度来说很小.
    //用什么排序比较好.
    //o(n2)的算法 选择 冒泡 与原始数列无关.插入不能保证移动最少.
    //O(nlogn)的算法 归并 快排 与初始顺序无关.所以堆排序比较适合
    //比起nlogn小很多

    public static void main(String[] args) {
        int a[] = {1,3,6,2,3,7,9,4};
        int b[] = {2,1,4,3,6,5,8,7,10,9};
        adjustK(a,5,3);
        System.out.println(Arrays.toString(a));

    }
    public static  void swap(int[] arr ,int index,int i ){
        int tmp = arr[index];
        arr[index] = arr[i];
        arr[i] = tmp;
    }
    public static  void adjustK(int[] arr,int start,int k){
        if (arr.length == 0 || arr == null){
            return ;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i = start;
        int len = k;
        for (i = k/2-1;i >= 0;i--){//循环建小根堆
            adjustSmallHeap(arr,i,k-1);
        }
        list.add(arr[arr.length - k]);
        for (int j = arr.length - k ;j > 0;j--){
            arr[arr.length - k] = arr[j];
            heapSort(arr);
            list.add(arr[arr.length - k]);
        }
        int s = 0;
        for (int w : list) {
            arr[s++] = w;
        }

    }

    public static void adjustSmallHeap(int[] arr,int index,int k){
        int temp,j;
        temp = arr[index];
        for (int i = 2*index ; i < k; i*=2) {//沿关键字较大的孩子节点向下筛选
            if(i < k && arr[i] > arr[i+1])++i;
            if (temp <= arr[i])break;
            arr[index] = arr[i];
            index = i;
        }
        arr[index] = temp;
    }
    public static void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个小顶堆
            adjustSmallHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustSmallHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
        }
    }
}
