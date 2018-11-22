package zuoshengsuanfa.jinjieban.class_5;

import java.util.HashMap;

/**
 *      毛毛雨     2018/11/1
 *      已知一个消息流会不断地吐出整数1~N，但不一定按照顺序吐出。
 *      如果上次打印的 数为i，那么当i+1出现时，请打印i+1及其之后接收过的并且连续的所有数，
 *      直到1~N 全部接收并打印完，请设计这种接收并打印的结构
 * */
public class Code_06_一种消息接收并打印的结构设计 {
    public static class Node{
        public int num;
        public Node next;
        public Node(int num) {
            this.num = num;
        }
    }

    public static class MessageBox{
        private HashMap<Integer,Node> headMap;
        private HashMap<Integer,Node> tailMap;
        private int lastPrint;

        public MessageBox() {
            headMap = new HashMap<>();
            tailMap = new HashMap<>();
            lastPrint = 0;
        }

        public void receive(int num){
            if (num < 1){
                return;
            }
            Node cur = new Node(num);
            headMap.put(num,cur);
            tailMap.put(num,cur);
            if (tailMap.containsKey(num -1 )){
                tailMap.get(num - 1).next = cur;
                tailMap.remove(num - 1);
                headMap.remove(num);
            }
            if (headMap.containsKey(num + 1)){
                cur.next = headMap.get(num + 1);
                headMap.remove(num + 1);
                tailMap.remove(num);
            }
            if (headMap.containsKey(lastPrint + 1)){
                print();
            }
        }
        private void print(){
            Node node = headMap.get(++lastPrint);
            headMap.remove(lastPrint);
            while (node != null){
                System.out.println(node.num + " ");
                node = node.next;
                lastPrint++;
            }
            tailMap.remove(--lastPrint);
            System.out.println();
        }

        public static void main(String[] args) {
            MessageBox box = new MessageBox();

            box.receive(2); // - 2
            box.receive(1); // 1 2 -> print, trigger is 1

            box.receive(4); // - 4
            box.receive(5); // - 4 5
            box.receive(7); // - 4 5 - 7
            box.receive(8); // - 4 5 - 7 8
            box.receive(6); // - 4 5 6 7 8
            box.receive(3); // 3 4 5 6 7 8 -> print, trigger is 3

            box.receive(9); // 9 -> print, trigger is 9

            box.receive(10); // 10 -> print, trigger is 10

            box.receive(12); // - 12
            box.receive(13); // - 12 13
            box.receive(11); // 11 12 13 -> print, trigger is 11
        }

    }

}
