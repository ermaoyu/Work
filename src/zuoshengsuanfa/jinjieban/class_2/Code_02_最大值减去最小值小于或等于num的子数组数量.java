package zuoshengsuanfa.jinjieban.class_2;

import java.util.LinkedList;

/**
 *      毛毛雨     2018/10/21
 * */
public class Code_02_最大值减去最小值小于或等于num的子数组数量 {

    public static int getMaxArrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        LinkedList<Integer> maxq = new LinkedList<>();
        LinkedList<Integer> minq = new LinkedList<>();
        int R = 0;
        int L = 0;
        int sum = 0;
        while (L < nums.length) {
            while (R < nums.length) {
                while (!maxq.isEmpty() && nums[maxq.peekLast()] <= nums[R]) {
                    maxq.pollLast();
                }
                maxq.addLast(R);
                while (!minq.isEmpty() && nums[minq.peekLast()] >= nums[R]) {
                    minq.pollLast();
                }
                minq.addLast(R);

                if (nums[maxq.peekFirst()] - nums[minq.peekFirst()] > k) {
                    break;
                }
                R++;
            }
            if (maxq.peekFirst() == L) {
                maxq.pollFirst();
            }
            if (minq.peekFirst() == L) {
                minq.pollFirst();
            }
            sum += R - L;
            L++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,};
        System.out.println(getMaxArrays(nums,0));
    }

}
