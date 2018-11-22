package arthmetic;

/**
 *      毛毛雨     2018/11/21
 * */
public class PrintMax {

    public static void printMax(int n){
        if (n < 0)return;
        StringBuffer num = new StringBuffer();
        for (int i = 0; i < n; i++) {
            num.append('0');
        }
        while (!Inc(num)){
            print(num);
        }
    }

    public static boolean Inc(StringBuffer num){
        boolean flag = false;
        int index = 0;
        for (int i = num.length() - 1; i >= 0 ; i--) {
            int sum = num.charAt(i) - '0' + index;
            if (i == num.length() - 1)sum++;
            if (sum >= 10){
                if (i == 0){
                    flag = true;
                }else{
                    index = 1;
                    sum -= 10;
                    num.setCharAt(i,(char)(sum+'0'));
                }
            }else {
                num.setCharAt(i,(char)(sum+'0'));
                break;
            }
        }
        return flag;
    }

    public static void print(StringBuffer num){
        boolean flag = true;
        for (int i = 0; i < num.length(); i++) {
            if (flag && num.charAt(i) !='0')
                flag = false;
                if (!flag) {
                    System.out.print(num.charAt(i));
                }
            }
            System.out.println();

    }

    public static void main(String[] args) {
        printMax(1);
    }

}
