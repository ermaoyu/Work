package arthmetic;


import java.util.Scanner;

public class TwoString {
    /**
     * 题目描述
     * 考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法：
     * 1.根据字符串的字典序排序。例如：
     * "car" < "carriage" < "cats" < "doggies < "koala"
     * 2.根据字符串的长度排序。例如：
     * "car" < "cats" < "koala" < "doggies" < "carriage"
     * 考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
     * 输入描述:
     * 输入第一行为字符串个数n(n ≤ 100)
     * 接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
     * 输出描述:
     * 如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",
     *
     * 如果根据长度排列而不是字典序排列输出"lengths",
     *
     * 如果两种方式都符合输出"both"，否则输出"none"
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flag1 = 0;
        int flag2 = 0;
        while(in.hasNext()) {
            int count = Integer.valueOf(in.nextLine());
            String[] data = new String[count];
            for (int i = 0; i <count; i++) {
                data[i] = in.nextLine();
            }

            for (int j = 0; j < count - 1; j++) {//判断长度是否按长度排序
                if (data[j].length() > data[j + 1].length()) {
                    flag1 = 1;
                    break;
                }
            }
            /**
             * 语法:Str1.compareTo(Str2);
             * 其返回的是一个int类型值。
             * 若Str1等于参数字符串Str2字符串，则返回0；
             * 若该Str1按字典顺序小于参数字符串Str2，则返回值小于0；
             * 若Str1按字典顺序大于参数字符串Str2，则返回值大于0
             * */

            for(int k=0;k<count-1;k++){
                if (data[k+1].compareTo(data[k])<=0){
                    flag2 = 1;
                    break;
                }
            }
            if(flag1 ==0&&flag2==0){
                System.out.print("both");
            }
            else if (flag1 == 0 &&flag2==1 ) {
                System.out.print("lengths");
            }
            else if (flag1 ==1&&flag2==0){
                System.out.print("lexicographically");
            }else {
                System.out.print("none");
            }
        }
        }

}
