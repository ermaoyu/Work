package zuoshengsuanfa.jinjieban.class_7;

/**
 *      毛毛雨     2018/11/6
 *      给定一个字符串str，请删除重复的字符（只保留一个）。
 *      但是 在所有删除方案中，请选择最后剩下的字符串是字典序最小的。
 *      返回最终的结果字符串。
 * */
public class Code_01_字典序最小 {
    public static String removeDuplicateLetters1(String s) {
        int[] chs = new int [26];
        int pos = 0;//挑出来的,最小ascii字符的位置
        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) < s.charAt(pos)){
                pos = i;
            }
            if (--chs[s.charAt(i) - 'a'] == 0){
                break;
            }
        }
        //0..i pos
        //pos位置字符被选出
        //删掉pos之前的字符
        //pos之后的字符串,一律去掉pos位置上的字符
        return s.length() == 0 ? "" : s.charAt(pos)//选择最小的字符为开头
                + removeDuplicateLetters1(s.substring(pos + 1).replaceAll("" + s.charAt(pos),""));
    }

    public static void main(String[] args) {
        String a = "bbaabca";
        System.out.println(removeDuplicateLetters1(a));
    }
}
