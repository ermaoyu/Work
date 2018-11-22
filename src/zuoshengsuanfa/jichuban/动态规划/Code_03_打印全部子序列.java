package zuoshengsuanfa.jichuban.动态规划;

public class Code_03_打印全部子序列 {

    public static void printStr(String str){
        char[] chs = str.toCharArray();
        String res = "";
        process(chs,0,res);
    }
    public static void process(char[] chs,int i,String str){
        if (i == chs.length){
            System.out.println(str);
            return;
        }
        process(chs,i+1,str);
        process(chs,i+1,str + String.valueOf(chs[i]));
    }

    public static void main(String[] args) {
        String str = "abc";
        printStr(str);
    }
}
