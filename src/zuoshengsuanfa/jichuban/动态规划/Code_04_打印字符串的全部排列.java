package zuoshengsuanfa.jichuban.动态规划;

import java.util.ArrayList;
import java.util.Collections;

/**
 *      毛毛雨     2018/10/31
 * */
public class Code_04_打印字符串的全部排列 {

    public static void printAll(String str){
        char[] chs = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        process(chs,0,list);
        Collections.sort(list);
    }
    public static void process(char[] chs,int i,ArrayList<String> list){
        if (i == chs.length){
            System.out.println(String.valueOf(chs));
            if (!list.contains(String.valueOf(chs))){
                list.add(String.valueOf(chs));
            }
        }
        for (int j = i;j<chs.length;j++){
            swap(chs,i,j);
            process(chs,i + 1,list);
            swap(chs,i,j);
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "abc";
        printAll(str);
    }
}
