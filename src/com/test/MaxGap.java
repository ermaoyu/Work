package com.test;

public class MaxGap {
    /**
     * 桶排序
     * */
    public static int maxGap(int[] nums){
        if(nums == null || nums.length < 2){
          return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找到数组中的最大值和最小值;
        for (int i = 0;i<len;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if (min == max){
            return 0;
        }
        boolean[] hasNum = new boolean[len+1] ;
        int[] mins = new int [len + 1] ;
        int[] maxs = new int [len + 1] ;
        int bid = 0;
        for (int i =0;i<len;i++){
            bid = bucket(nums[i],len,min,max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],nums[i]) : nums[i] ;
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],nums[i]) : nums[i] ;
            hasNum[bid] = true ;
        }
        int res = 0;
        int lastmax = maxs[0];//赋予第一个桶的最大值
        int i = 1 ;
        for(;i<len;i++){
            if(hasNum[i]){
                res =Math.max(res,mins[i] - lastmax);//从第二个非空桶开始,拿它的最小值和左侧最大值比较差值
                lastmax = res;
            }
        }
        return res;
    }

    private static int bucket(int num, int len, int min, int max) {
        return (int )((num-min)*len/(max - min));
    }


    public static void main(String[] args) {
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int max = maxGap(a);
        System.out.print(max);
    }


}
