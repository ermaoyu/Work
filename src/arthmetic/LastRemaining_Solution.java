package arthmetic;

import java.util.ArrayList;

public class LastRemaining_Solution {
    /**
     *随机指定一个数m,让编号为0的小朋友开始报数。
     * 每次喊到m-1的那个小朋友要出列唱首歌,
     * 然后可以在礼品箱中任意的挑选礼物,
     * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
     * 直到剩下最后一个小朋友,可以不用表演
     * */
    public int lastRemaining_Solution(int n, int m) {
            if(m < 1 || n < 1){
                return -1;
            }

            int index = 0;
            for(int i = 2 ;i <=n;i++){
                index = (index + m) % i;
            }
            return index+1;
    }
}
