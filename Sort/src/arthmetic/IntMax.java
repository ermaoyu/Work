package arthmetic;

import java.util.Scanner;

public class IntMax {
    /**
     * 题目描述
     * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
     * "正整数最大,意思就是从左往右只要左边数小于右边就删除,这样就能保持最大"
     *
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append(in.next());
            int m = in.nextInt();

            for (int i = 0; i < m; i++) {
                int j = 0;
                while (j + 1 < sb.length() && sb.charAt(j) >= sb.charAt(j + 1)) {
                    j++;
                }
                sb.deleteCharAt(j);
            }
            System.out.println(sb.toString());
        }
    }
}
