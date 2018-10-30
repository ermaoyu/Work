package zuoshengsuanfa.jichuban.字符串;

/**
 *      毛毛雨     2018/10/27
 *
 * */
public class Code_02_计算回文字符串的最大长度 {
    public int longet(String str){
        int[] cnts = new int[128];
        for (char c : str.toCharArray()) {
            cnts[c]++;
        }
        int ret = 0;
        for (int cnt : cnts) {
            ret += (cnt/2)*2;
        }
        if (ret < str.length())ret++;//这时候肯定str中有单个字符出现,可以把他放到中心长度加1

        return ret;
    }
}
