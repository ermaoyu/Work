package zuoshengsuanfa.jinjieban.class_6;


import java.util.HashMap;
import java.util.HashSet;

/**
 *      毛毛雨     2018/11/2
 *      哈希表常见的三个操作是put、get和containsKey，而且这三个操作的 时间复杂度为O(1)。
 *      现在想加一个setAll功能，就是把所有记录的 value都设成统一的值。
 *      请设计并实现这种有setAll功能的哈希表，
 *      并 且put、get、containsKey和setAll四个操作的时间复杂度都为O(1)
 * */
public class Code_02_HashMapSetAll {
    public static class MyValue<V>{
        private V value;
        private long time;

        public MyValue(V value, long time) {
            this.value = value;
            this.time = time;
        }

        public V getValue() {
            return value;
        }

        public long getTime() {
            return time;
        }
    }

    public static class MyHashMap<K,V>{
        private HashMap<K,MyValue<V>> map;
        private long time;
        private MyValue<V> setAll;

        public MyHashMap() {
            this.map = new HashMap<K,MyValue<V>>();
            this.time = 0;
            this.setAll = new MyValue<V>(null,-1);
        }

        public boolean containsKey(K key){
            return this.map.containsKey(key);
        }

        public void put(K key,V value){
            this.map.put(key,new MyValue<V>(value,this.time++));
        }

        public void setAll(V value){
            this.setAll = new MyValue<V>(value,this.time++);
        }

        public V get(K key){
            if (this.map.containsKey(key)){
                if (this.map.get(key).getTime() > this.setAll.getTime()){
                    return this.map.get(key).getValue();
                }else {
                    return this.setAll.getValue();
                }
            }else {
                return null;
            }
        }

    }
    public static void main(String[] args) {
        MyHashMap<String, Integer> test = new MyHashMap<String, Integer>();
        test.put("Tom", 1);
        test.put("James", 2);
        System.out.println(test.containsKey("Tom"));
        System.out.println(test.get("Tom"));
        System.out.println(test.containsKey("James"));
        System.out.println(test.get("James"));
        test.setAll(3);
        test.put("Rose", 4);
        System.out.println(test.get("Tom"));
        System.out.println(test.get("James"));
        System.out.println(test.get("Rose"));
        test.setAll(5);
        System.out.println(test.get("Tom"));
        System.out.println(test.get("James"));
        System.out.println(test.get("Rose"));

    }

}
