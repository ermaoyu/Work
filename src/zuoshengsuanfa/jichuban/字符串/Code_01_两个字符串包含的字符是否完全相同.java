package zuoshengsuanfa.jichuban.字符串;

/**
 *      毛毛雨     2018/10/27
 * */
public class Code_01_两个字符串包含的字符是否完全相同 {
    public boolean isAanagram(String str1,String str2){
        if (str1.length() == 0 || str2.length() == 0 ||
            str1 == null || str2 == null ){
            return false;
        }
        char[] cn = new char[26];
        for (int i = 0; i < str1.length(); i++) {
            cn[str1.charAt(i)-'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            cn[str2.charAt(i) -'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cn[i] != 0){
                return false;
            }
        }
        return true;
    }
}
