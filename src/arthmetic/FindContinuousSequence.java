package arthmetic;

import java.util.ArrayList;

/**
 *      毛毛雨     2018/11/1
 *      输出所有和为S的连续正数序列。
 *      序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *      双指针,和小于sum时,大指针++
 *      大于sum时,小指针++
 * */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        int high = 2;
        int low = 1;
        while (high > low){
            int cur = (high + low)*(high - low + 1)/2;
            if (cur < sum)
                high++;
            if (cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low;i <= high;i++){
                    list.add(i);
                }
                lists.add(list);
                high++;
            }
            if (cur >sum){
                low++;
            }

        }
        return lists;
    }
}
