package arthmetic;

public class GetNumberOfK {
    /**
     * 统计一个数字在排序数组中出现的次数。
     */
    //有序的数组,用二分查找法找出第一个K的下标减最后一个K的下标
    public static int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = findfirst(array, k, 0, array.length - 1);
        int last = findlast(array, k, 0, array.length - 1);
        if (first == -1 || last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    public static int findfirst(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else if (mid -1 >= 0 && array[mid - 1] == k) {
                end = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findlast(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else if (mid + 1<= array.length - 1 && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3};
        System.out.println(getNumberOfK(a,3));
    }
}
