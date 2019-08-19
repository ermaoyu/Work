package zuoshengsuanfa.jinjieban.class_4;

public class Code_01_n级汉诺塔问题 {
    //1) 1-n-1 移到other上去
    //2) n 移到 to 上去
    //3) 1-n-1移到to上去

    public static void hanoi(int n){
        if (n>0){
            func(n,"A","B","C");
        }
    }
    //1-n,此时都在from上,
    //1-n.全部从from,到to上,另一个杆是other
    //一个子过程
    public static void func(int n,String A,String B,String C){
        if (n == 1){
            System.out.println("move from " + A +" to " +B);
        }else {
            func(n-1,A,C,B);
            func(1,A,B,C);
            func(n-1,C,B,A);
        }
    }

    public static void main(String[] args) {
        hanoi(4);
    }





}
