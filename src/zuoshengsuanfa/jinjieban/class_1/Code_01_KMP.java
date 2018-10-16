package zuoshengsuanfa.jinjieban.class_1;
/**
 *  毛毛雨  2018/10/16  KMP
 *  KMP算法解决字符串比较问题
 *  用法:两个字符串s1,s2判断s2是否为s1的子串
 * */
public class Code_01_KMP {


    public static int getIndexOf(String s,String m){
        if (s.length() == 0 || m.length() == 0 || s == null || m == null){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int [] next = getNext(str2);
        int x = 0;
        int cn = 0;
        while(x < str1.length && cn < str2.length){
            if (str1[x] == str2[cn]){
                ++x;
                ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                ++x;
            }
        }
        return cn == str2.length? x - cn : -1;
    }
    /**
     * next[]数组求解
     * */
    private static int[] getNext(char[] str2) {
        if(str2.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while(i < next.length){
            if (str2[i-1] == str2[cn]){
                next[i++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "abcabcababaccc";
        String m = "abac";
        System.out.println(getIndexOf(s,m));
    }
}
