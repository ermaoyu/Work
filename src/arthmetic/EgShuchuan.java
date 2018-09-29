package arthmetic;
import java.util.Scanner;
import java.util.*;
public class EgShuchuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//等待键盘输入数据,回车为确定符号
            /**
             * 将键盘中输入的数字存放到数组中,摁下空格时为隔开
             * */
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            Collections.sort(list, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1 = String.valueOf(o1);
                    String s2 = String.valueOf(o2);
                    /**  compare:
                     *   返回值<0   前面的<后面的,位置排前
                     *   返回值=0  前面的=后面的,位置不变
                     *   返回值>0  前面的>后面的,位置靠后
                     * 语法:Str1.compareTo(Str2);
                     * 其返回的是一个int类型值。
                     * 若Str1等于参数字符串Str2字符串，则返回0；
                     * 若该Str1按字典顺序小于参数字符串Str2，则返回值小于0；
                     * 若Str1按字典顺序大于参数字符串Str2，则返回值大于0
                     * **/
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}
