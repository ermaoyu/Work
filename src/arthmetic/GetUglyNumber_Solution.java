package arthmetic;

import java.util.ArrayList;

public class GetUglyNumber_Solution {
    /**题目描述
     把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     例如6、8都是丑数，但14不是，因为它包含质因子7。
     习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     链接：https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b
     来源：牛客网

     2.为什么比较三个队列头部最小的数放入丑数数组？
     因为三个队列是有序的，所以取出三个头中最小的，等同于找到了三个队列所有数中最小的。
     实现思路：
     我们没有必要维护三个队列，只需要记录三个指针显示到达哪一步；“|”表示指针,arr表示丑数数组；
     （1）1
     |2
     |3
     |5
     目前指针指向0,0,0，队列头arr[0] * 2 = 2,  arr[0] * 3 = 3,  arr[0] * 5 = 5
     （2）1 2
     2 |4
     |3 6
     |5 10
     目前指针指向1,0,0，队列头arr[1] * 2 = 4,  arr[0] * 3 = 3, arr[0] * 5 = 5
     （3）1 2 3
     2| 4 6
     3 |6 9
     |5 10 15
     目前指针指向1,1,0，队列头arr[1] * 2 = 4,  arr[1] * 3 = 6, arr[0] * 5 = 5
     * */
    public int getUglyNumber_Solution(int index) {
        if(index < 7){
            return index;
        }
        int t2 = 0,t3 = 0, t5 = 0;//代表2 ,3 ,5的下标指针
        int[] num = new int[index];
        num[0] = 1;
        for (int i = 1;i<index;i++){
            num[i] = Math.min(num[t2]*2,Math.min(num[t3]*3,num[t5]*5));
            if (num[i]==num[i]*2)t2++;
            if (num[i]==num[i]*3)t3++;
            if (num[i]==num[i]*5)t5++;
        }
        return num[index-1];
    }
}
