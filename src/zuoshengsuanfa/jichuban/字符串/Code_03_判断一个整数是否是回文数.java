package zuoshengsuanfa.jichuban.字符串;

/**
 *      毛毛雨     2018/10/27
 *      判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * */
public class Code_03_判断一个整数是否是回文数 {

    public boolean manacherSort(int num){
        if (num == 0){
            return true;
        }
        if (num < 0 || num%10 == 0){
            return false;
        }
        int right = 0;
        while (num > right){
            right = right * 10 + num%10;//反转右半部分
            num /= 10;
        }
        return num == right || num == right/10 ;
    }
}
