package arthmetic;

import java.util.Scanner;

public class Shuliedehe {
    /**
     *数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
     * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
     * 81 4
     * 2 2
     * 输出
     *
     * 94.73
     * 3.41
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            double sum = n;
            double [] data = new double[m];
            data[0] = n;
            for (int i = 1;i<m;i++ ){
                data[i] = Math.sqrt(data[i-1]);
                sum += data[i];
            }
            System.out.print(String.format("%.2f",sum));
        }
    }
}
