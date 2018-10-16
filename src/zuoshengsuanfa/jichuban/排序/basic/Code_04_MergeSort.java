package zuoshengsuanfa.jichuban.排序.basic;

import java.util.Arrays;

/**
 *   毛毛雨  2018/10/16  归并排序
 *   简介:将两个(或者两个以上)有序表合成一个有序表,即把待排序的序列分成若干子序列.每个子序列都是有序的.然后再把子序列合并
 *   时间复杂度:O(nlogn)
 *   @pamra nums 待排序数组
 *   @return 输出有序数组
 * */

public class Code_04_MergeSort {

    public static int[] sort(int[] nums,int low ,int high){
        int mid = (low + high)/2;
        if (low < high){
            //左边
            sort(nums,low,mid);
            //右边
            sort(nums,mid+1,high);
            //左右合并
            merge(nums,low,mid,high);
        }
        return nums;
    }

    public static void merge(int[] nums,int low ,int mid,int high){
        int[] tmp = new int [high - low + 1];
        int j = low;//左指针
        int i = mid + 1;//右指针
        int k = 0;

        //把较小的数先移到数组中
        while(i<= mid && j<= high){
            tmp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }

        //把左边剩余的数移入数组
        while(i <= mid){
            tmp[k++] = nums[i++];
        }

        //把右边剩余的数移入数组
        while(j <= high){
            tmp[k++] = nums[j++];
        }
        //把新的数组覆盖nums数组
        for (int index = 0;index < tmp.length;index++){
            nums[index + low] = tmp[index];
        }
    }

    //归并排序的实现
    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
