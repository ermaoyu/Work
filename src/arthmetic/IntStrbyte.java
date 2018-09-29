package arthmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntStrbyte {//正整数转2进制数
    public static void main(String[] args) {
        int n = 4;
        int sum = 0;
        String str = "";
        while (n>0) {
            int tmp = n % 2;
            n = n/2;
            if(tmp == 1){
                sum +=1;
            }
            str = tmp + str;
        }
        System.out.println(sum);
        List<String> list = new ArrayList<>();
        list.add(str);
        Collections.reverse(list);
        System.out.println(list.get(0).toString());
    }
}
