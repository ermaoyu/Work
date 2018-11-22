package zuoshengsuanfa.jichuban.字符串;

/**
 *      毛毛雨     2018/11/20
 * */
public class Code_05_替换字符串中的空格 {

    public static  String replaceSpace(StringBuffer str){
        if (str == null || str.length() == 0)return str.toString();
        int len = str.length();
        int newlen = 0;
        for (int i = 0;i < len;i++){
            if (str.charAt(i) == ' '){
                newlen += 3;
            }else {
                newlen++;
            }
        }
        str.setLength(newlen);
        int j = newlen-1;
        for (int i = len -1;i>=0;i--){
            if (str.charAt(i)==' '){
                str.setCharAt(j--,'0');
                str.setCharAt(j--,'2');
                str.setCharAt(j--,'%');
            }else {
                str.setCharAt(j--,str.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("  ");
        System.out.println(replaceSpace(sb));
    }
}
