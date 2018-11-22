package zuoshengsuanfa.jinjieban.class_5;

public class Code_02_长度相等的两个有序数组求上中位数 {

    public static int getMidNum(int[] a,int[] b) {
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return -1;
        }
        int L1 = 0;
        int R1 = a.length ;
        int L2 = 0;
        int R2 = b.length ;
        while (L1 < R1) {
            int mid1 = (L1 + R1) >> 1;
            int mid2 = (L2 + R2) >> 1;
            if (a[mid1] == b[mid2]) {
                return a[mid1];
            } else if (a[mid1] > b[mid2]) {
                if ((int) ((R1 - L1 + 1) & 1) == 0) {//长度为偶数
                    R1 = mid1;
                    L2 = mid2 + 1;
                } else {//长度为奇数
                    if (b[mid2] >= a[mid1 - 1]) {
                        return b[mid2];
                    } else {
                        R1 = mid1 - 1;
                        L2 = mid2 + 1;
                    }
                }
            }else {//a[mid1] < b[mid2]
                if ((int) ((R1 - L1 + 1) & 1) == 0) {//长度为偶数
                    L1 = mid1 +1;
                    R2 = mid2 ;
                } else {//长度为奇数
                    if (a[mid1] >= b[mid2 - 1]) {
                        return a[mid1];
                    } else {
                        L1 = mid1 + 1;
                        R2 = mid2 - 1;
                    }
                }
            }

        }
            return -1;
    }

    public  static int getMid(int[] a,int[] b){
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return -1;
        }
        int L1 = 0;
        int R1 = a.length - 1;
        int L2 = 0;
        int R2 = b.length - 1;
        int mid1 = 0;
        int mid2 = 0;
        int index = 0;

        return Math.min(a[L1], b[L2]);
    }

    public static void main(String[] args) {
        int[] a = {1,6};
        int[] b = {2,4};
        System.out.println(getMidNum(a,b));
    }

}
