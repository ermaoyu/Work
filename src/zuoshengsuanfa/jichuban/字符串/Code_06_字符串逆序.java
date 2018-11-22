package zuoshengsuanfa.jichuban.字符串;

/**
 *      毛毛雨     2018/11/20
 *      先将整句逆序,再将单词逆序
 * */
public class Code_06_字符串逆序 {

    public static String reverseSentence(String str){
        if (str == null || str.length() == 0)return str;
        char[] a = str.toCharArray();
        reverse(a,0,a.length - 1);
        int i = 0;
        int start = 0;
        while(i <= a.length - 1){
            if (i > 1 && a[i] == ' '){
                reverse(a,start,i - 1);//i = ' ';
                start = i + 1;
            }else if (i == a.length - 1){
                reverse(a,start,i);
            }
            i++;
        }
        return String.valueOf(a);
    }
    public static void reverse(char[] a,int i,int j){
        int l = i;
        int r = j;
        while(l < r){
            char tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String str = "i am a boy";
        System.out.println(reverseSentence(str));
    }

}
