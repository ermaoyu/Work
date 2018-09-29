package arthmetic;

import java.util.*;

public class ShuChuan {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/a6a656249f404eb498d16b2f8eaa2c60
     * 来源：牛客网
     * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
     * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
     * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613
     * */
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();//数组中包含几个数字的数字
            List<Integer> list = new ArrayList<>();
            for (int i =0;i<n;i++){
                list.add(in.nextInt());
            }
            Collections.sort(list, new Comparator<Integer>() {//比较器
                @Override
                public int compare(Integer o1, Integer o2) {
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
                    String s1 = String.valueOf(o1);
                    String s2 = String.valueOf(o2);
                    return (s2+s1).compareTo(s1+s2);
                }
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}
