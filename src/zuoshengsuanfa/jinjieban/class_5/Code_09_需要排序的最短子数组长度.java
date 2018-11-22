package zuoshengsuanfa.jinjieban.class_5;

/**
 *      毛毛雨     2018/11/1
 *      给定一个无序数组arr，求出需要排序的最短子数组长度。
 *      例如：arr = [1，5，3，4，2，6，7]返回4，
 *      因为只有[5，3，4，2]需要排序。
 * */
public class Code_09_需要排序的最短子数组长度 {
    public static int getMinLength(int[] a){
        if (a == null || a.length == 0){
            return 0;
        }
        int min = a[a.length - 1];
        int minIndex = -1;
        for (int i = a.length - 2;i != -1;i-- ){//从右往左,当前值是否比最小值小
            if (a[i] > min){//如过大,肯定能的到最左侧最小的下标
                minIndex = i;
            }else {
                min = Math.min(min,a[i]);
            }
        }
        if (minIndex == -1){
            return 0;
        }
        int max = a[0];
        int maxIndex = -1;
        for (int i = 1;i != a.length;i++){//从左往右,左侧最大值,是否比当前值大
            if (a[i] < max){//如果当前值小于最大值,记住下标,右侧肯定是需要排序的最大下标
                maxIndex = i;
            }else {
                max =  Math.max(max, a[i]);
            }
        }
        return maxIndex - minIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
        System.out.println(getMinLength(arr));
    }
}
