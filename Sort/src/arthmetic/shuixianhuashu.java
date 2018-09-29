package arthmetic;

import java.util.Scanner;

public class shuixianhuashu {
    /***
     *春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，
     * 他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。
     * 现在要求输出所有在m和n范围内的水仙花数。
     * 输入描述:
     * 输入数据有多组，每组占一行，包括两个整数m和n（100 ≤ m ≤ n ≤ 999）。
     * 输出描述:
     * 对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，
     * 如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开;
     * 如果给定的范围内不存在水仙花数，则输出no;
     * 每个测试实例的输出占一行。
     * 输入
     * 100 120
     * 300 380
     * 输出
     * no
     * 370 371
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int min =  in.nextInt();
            int max = in.nextInt();
            int len = max - min;
            int flag = 0;
            int[] sb = new int[len];
            for(int j = 0;j<len;j++){
                int tmp = min + j;
                int a = tmp/100;//获得最高位数
                int b = (tmp%100)/10;//获得十位数;
                int c = tmp%10;//获得个位数;
                if(tmp == ((a*a*a)+(b*b*b)+(c*c*c))) {
                    sb[flag] = tmp;
                    flag += 1;
                }
            }
            if (flag == 0){
                System.out.print("no");
                return ;
            }
            for (int k =0;k<flag;k++){
                System.out.print(sb[k]);
                if(k<flag-1){
                    System.out.print(" ");
                }
            }
        }
    }
}
