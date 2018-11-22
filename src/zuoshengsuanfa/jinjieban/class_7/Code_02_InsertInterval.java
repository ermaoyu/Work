package zuoshengsuanfa.jinjieban.class_7;

import java.util.ArrayList;
import java.util.List;

/**
 *      毛毛雨     2018/11/6
 *
 * */
public class Code_02_InsertInterval {
    public static class Interval{
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> insert(List<Interval> items,Interval index ){
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while(i < items.size() && items.get(i).end < index.start){
            res.add(items.get(i++));
        }
        while(i < items.size() && items.get(i).start <= index.end){
            index.start = Math.min(index.start,items.get(i).start);
            index.end = Math.max(index.end,items.get(i).end);
            i++;
        }
        res.add(index);
        while (i < items.size()){
            res.add(items.get(i++));
        }
        return res;
    }
}
