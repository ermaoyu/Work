package arthmetic;

import java.util.Scanner;

public class Shuzufanzhuan {
    /***
     * 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao mi”-> “mi xiao hello”
     * 输入描述:
     * 输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
     * 输出描述:
     * 对于每个测试示例，要求输出句子中单词反转后形成的句子
     * 输入
     * hello xiao mi
     * 输出
     * mi xiao hello
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String arr = in.nextLine();
            String[] data = arr.split(" ");
            for (int i = data.length - 1; i > -1; i--) {
                System.out.print(data[i]);
                if (i > 0) {
                    System.out.print(" ");
                }
            }
        }
    }


}
