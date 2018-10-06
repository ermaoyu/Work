package arthmetic;

public class LeftRotateString {
    /**
     *汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
     * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
     * 请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,
     * 要求输出循环左移3位后的结果，即“XYZdefabc”
     * */
    public String leftRotateString(String str,int n) {
        if (str == null || str.length()==0)return "";
        StringBuffer sb = new StringBuffer(str.substring(0,n%str.length()));
        StringBuffer sb2 = new StringBuffer(str.substring(n%str.length(),str.length()-1));
        sb2.append(sb);
        return sb2.toString();
    }
    public String leftRotateString2(String str,int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n){
            return str;
        }
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }
    public void reverse(char[] chars, int start, int end){
        while(start < end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
