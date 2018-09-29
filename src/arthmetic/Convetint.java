package arthmetic;

import java.util.Scanner;

public class Convetint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strin = in.nextLine();
        String[] str = strin.split(" ");
        int i = Integer.valueOf(str[0]);
        int j = Integer.valueOf(str[1]);
        System.out.println(test(i,j).reverse().toString());
    }
    public static StringBuffer test(int i,int j){
        StringBuffer sb = new StringBuffer();
        char[] arr = {'A','B','C','D','E','F'};
        int index = i ;
        int temp = 0;
        boolean flag = false;
        if(index < 0){
            index = -index;
            flag = true;
        }

        while(index != 0){
            temp = index % j;
            if(temp > 9){
                sb.append(arr[temp - 10]);
            } else {
               sb.append(temp);
            }
            index = index/j;
        }
        if(flag){
            sb.append("-");
        }
        return sb;
    }
}
