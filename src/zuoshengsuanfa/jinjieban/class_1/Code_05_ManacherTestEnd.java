package zuoshengsuanfa.jinjieban.class_1;

/**
 *      毛毛雨     2018/10/21
 *      给定一个字符串,在尾部加上一段
 *      使他变成最短回文
 * */
public class Code_05_ManacherTestEnd {

    public static  char[] manacherString (String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2+1];
        int index = 0;
        for (int i = 0;i != res.length; i++){
            res[i] = (i & 1)==0?'#':charArr[index++];
        }
        return res;
    }

    public static String sortEnd(String str){
        if (str.length() == 0 || str == null){
            return str;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int maxContainsEnd = -1;
        for (int i = 0;i != charArr.length;i++){
            pArr[i] = pR > i ? Math.min(pArr[2*index - i],pR - i) : 1;
            while(i + pArr[i] < charArr.length && i - pArr[i] > -1){
                if(charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++ ;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > pR){
                pR = i + pArr[i];
                index = i;
            }
            if (pR == charArr.length){
                maxContainsEnd = pArr[i];
                break;
            }
        }
        char[] res = new char[str.length() - maxContainsEnd + 1];
        for (int i = 0;i < res.length;i++){
            res[res.length - 1 - i] = charArr[i*2+1];//倒序
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str2 = "abcd12321";
        System.out.println(str2);
        System.out.println(sortEnd(str2));
    }

}
