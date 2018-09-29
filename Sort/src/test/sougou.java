package test;
import java.util.Scanner;
import java.util.Collections;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
public class sougou {
        public static boolean init(int[] b){
            if (b == null){
                return false;
            }
            int L = b[0];
            int R = b[1];
            int W = b[2];
            int tmp = L;
            if(L != 0){
                if(tmp>=R){
                    tmp -= R;
                }else{
                    return false;
                }
                if(tmp>=W){
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        }
        public static void main(String[] args) {
            // System.arraycopy(original, 0, destination, length);
            // Arrays.copyOf(original, newLength);
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {//注意while处理多个case
                int a = Integer.valueOf(in.nextLine());
                ArrayList<int[]> list = new ArrayList<int[]>();
                for(int i = 0;i<a;i++){
                    int[] b = new int[3];
                    String strdata = in.nextLine();
                    String[] str = strdata.split(" ");
                    for (int j = 0;j<str.length;j++){
                        b[j] = Integer.valueOf(str[j]);
                    }
                    list.add(b);
                }
                for(int i = 0;i<a;i++){
                    boolean flag = new sougou().init(list.get(i));
                    if(flag){
                        System.out.println("NO");
                    }else{
                        System.out.println("YES");
                    }
                }

            }
        }
}
