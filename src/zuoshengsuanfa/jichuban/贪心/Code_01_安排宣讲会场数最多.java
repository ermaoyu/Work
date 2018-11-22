package zuoshengsuanfa.jichuban.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 *      毛毛雨     2018/10/31
 * */
public class Code_01_安排宣讲会场数最多 {
    public static class Program{
        public int start;
        public int end;
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static int getSum(Program[] programs,int start){
        Arrays.sort(programs, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;//谁先结束谁排前面
            }
        });
        int res = 0;
        for (int i=0;i<programs.length;i++){
            if (programs[i].start < start){
                res++;
                start = programs[i].end;
            }
        }
        return res;
    }
}
