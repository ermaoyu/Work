package zuoshengsuanfa.jichuban.QueueAndStack.basic;

import zuoshengsuanfa.jichuban.QueueAndStack.basic.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *      毛毛雨     2018/10/22   广度优先搜索
 * */
public class BFS {
    public static void bfsSort(Node node){
        if (node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();//防止图中指向同一的节点进入
        queue.add(node);
        map.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next:cur.nexts) {
                if(!map.contains(next)){
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
