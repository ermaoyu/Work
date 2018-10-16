package zuoshengsuanfa.jinjieban.class_1;

/**
 *  毛毛雨  2018/10/15  最大回文O(n)
 * */
public class Manacher {

    public static  char[]  manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[charArr.length * 2 +1];
        int index = 0;
        for (int i =0; i != res.length;i++){
            res[i] = (i & 1) == 0 ? '#' : charArr[index];
        }
        return res;
    }

    public static  int maxLcpsLength(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int [charArr.length];
        int R = -1;//R - 1为最右边界,R是最右边界的下一个位置
        int C = -1;//使R向右增长时,回文的中心
        int max = Integer.MIN_VALUE;
        for(int i = 0;i != charArr.length;i++){
            pArr[i] = R > i ? Math.min(R - i,pArr[2*C - i]) : 1;
            while(i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
                if (i + pArr[i] > R){
                    R = i + pArr[i];
                    C = i;
                }
                max = Math.max(max,pArr[i]);
        }
        return max - 1;


    }

}
