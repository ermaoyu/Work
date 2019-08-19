package zuoshengsuanfa.jinjieban.class_4;

public class Code_02_汉诺塔数组求第几步 {
    //{2,2,3}
    // 0 1 2
    public static void step1(int[] a){

    }
    //i是1-n-1
    public static int process(int[] a,int i,int from,int other,int to){
        if (i == -1){
            return 0;
        }
        if (a[i] != from && a[i] != to){//无效状态
            return -1;
        }
        if (a[i] == from ){//表示第一大步没走完,这时往上找一直找到不在from的最大的数
            return process(a,i-1,from,to,other);
        }else {
            //a[i] == to,第一大步和第二大步已经走完,目前正在走第三步
            int res = process(a,i -1 ,other,from,to);//第三步走到什么情况了
            if (res == -1){
                return -1;
            }
            return (1<<i) + res;//(n级罗汉塔移动完成需要2^n - 1步)
        }
    }
}
