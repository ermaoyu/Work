package zuoshengsuanfa.jinjieban.class_5;

/**
 *      毛毛雨     2018/11/3
 *      给定两个有序数组，求两个数组中整体的第k小的数
 * */
public class Code_03_求两个数组中整体的第k小的数 {
    /**
     *      k有三种情况
     *      1) 1 < k < shorts
     *      2) shorts < k < longs
     *      3) longs < k < longs + shorts
     * */
    public static int findKNum(int[] a,int[] b,int k){
        if (a == null || b == null){
            throw new RuntimeException("数组为空!");
        }
        if (k < 1 || k > a.length + b.length);
        int[] longs = a.length >= b.length ? a : b;
        int[] shorts = a.length < b.length ? a : b;
        int l = longs.length;
        int s = shorts.length;
        if (k <= s){//第一种情况,直接取longs和shorts数组的前K位取上中位数即可
            return getMid(shorts,0,k - 1,longs, 0 , k -1 );
        }
        if ( k > l){//第三种情况,shorts数组中,k - l -1开始的数都有可能为第k小的数
                    //longs数组中,k - s - 1的数开始可能为第k小的数
            if (shorts[k - l -1]>=longs[l - 1]){
                return shorts[k - l -1];
            }
            if (longs[k - s -1]>=shorts[s - 1]){
                return longs[k - s- 1];
            }
            return getMid(shorts,k - l,s - 1,longs,k - s,l -1 );
        }
        if (longs[k - s - 1] >= shorts[s -1]){//第二种情况,shorts剩余的长度比longs小一个,shorts中所有的数都可能为第K小的数
            return longs[k - s - 1];
        }
        return getMid(shorts,0,s -1,longs,k -s ,k -1 );
    }

    public static int getMid(int[] shorts,int start1,int end1,int[] longs,int start2,int end2){
        int mid1 = 0;
        int mid2 = 0;
        int index = 0;
        while (start1 < end1){
            mid1 = (start1 + end1) / 2;
            mid2 = (start2 + end2) / 2;
            index = ((end1 - start1 + 1) & 1) ^ 1;//判断奇偶,奇数index=0,偶数index=1;
            if (shorts[mid1] > longs[mid2]){
                end1 = mid1;
                start2 = mid2 + index;
            }else if (shorts[mid1] < longs[mid2]){
                start1 = mid1 + index;
                end2 = mid2;
            }else {
                return shorts[mid1];
            }
        }
        return Math.min(shorts[start1],longs[start2]);
    }
}
