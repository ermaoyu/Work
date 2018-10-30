package zuoshengsuanfa.jinjieban.class_4;

public class Code_01_n级汉诺塔问题 {
    //1) 1-n-1 移到other上去
    //2) n 移到 to 上去
    //3) 1-n-1移到to上去

    public static void hanoi(int n){
        if (n>0){
            func(n,"from","to","other");
        }
    }
    //1-n,此时都在from上,
    //1-n.全部从from,到to上,另一个杆是other
    //一个子过程
    public static void func(int n,String from,String other,String to){
        if (n == 1){
            System.out.println("move from " + from +"to" +to);
        }else {
            func(n-1,from,to,other);
            func(1,from,other,to);
            func(n-1,other,from,to);
        }
    }




}
