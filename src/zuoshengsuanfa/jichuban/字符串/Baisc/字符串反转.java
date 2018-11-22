package zuoshengsuanfa.jichuban.字符串.Baisc;

/**
 *      毛毛雨     2018/11/20
 * */
public class 字符串反转 {
    public static void  reverse(char[] str){
        if (str == null || str.length == 0)return ;
        int i = 0;
        int j = str.length - 1;
        while(i < j){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }
}
