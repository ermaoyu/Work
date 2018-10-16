package zuoshengsuanfa.jinjieban.class_1;
/**
 *   毛毛雨  2018/10/15 给定一个字符串,加上字符使他有最大前后缀
 * */
public class Code_02_KMP_ShortestTwice {
    public static String answer(String s){
        if (s.length() == 0 || s == null){
            return s;
        }
        char[] str = s.toCharArray();
        if (str.length == 1){
            return s + s;
        }
        if (str.length == 2){
            return str[0] == str[1]?s + String.valueOf(str[0]):(s + s);
        }
        int endNext = getendNext(str);
        return s + s.substring(endNext);
    }

    public static int getendNext(char[] str){
        int[] next = new int[str.length + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while(pos < next.length){
            if (str[pos -1 ] == str[cn]){
               next[pos++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else {
                next[pos++] = 0;
            }
        }
        return next[next.length-1];

    }

    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(answer(test1));

        String test2 = "aa";
        System.out.println(answer(test2));

        String test3 = "ab";
        System.out.println(answer(test3));

        String test4 = "abcdabcd";
        System.out.println(answer(test4));

        String test5 = "abracadabra";
        System.out.println(test5);
        System.out.println(answer(test5));
    }
}
