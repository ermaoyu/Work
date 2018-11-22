package zuoshengsuanfa.jinjieban.class_5;

import java.util.HashMap;

public class Code_10_LRU {
    public static class LRUCahe<K,V>{
        static class Node<K,V>{
            private K key;
            private V value;
            private Node pre;
            private Node next;
            public Node() {
            }

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        //指定容量
        private int cap;
        //保留潜水的双向链表的头尾指针
        private Node<K,V> head;
        private Node<K,V> tail;
        //保存键值对的map
        private HashMap<K,Node<K,V>> map;

        public LRUCahe(int cap) {
            //指定容量防止hashmap扩容
            this.cap = cap;
            //初始化头尾节点,这里的头节点是辅助节点
            //head节点不存储任何有效元素
            head = new Node();
            tail = head;
            map = new HashMap<>((int)(cap/0.75+1));
        }
        //删除节点操作,从链表中删除指定节点
        private void removeNode(Node<K,V> root){
            if (root == tail ){
                tail = tail.pre;
                tail.next = null;
                root.pre = null;
            }else if(root == head){
                head = head.next;
                head.pre = null;
                root.next = null;
            }else {
                root.pre.next = root.next;
                root.next.pre = root.pre;
                root.next = null;
                root.pre = null;
            }
        }

        //将指定节点追加到链表尾
        private void add(Node<K,V> root){
            tail.next = root;
            root.pre = tail;
            tail = root;
        }

        //访问一个键值对
        public V get(K key){
            Node<K,V> root = map.get(key);
            //不存在
            if (root == null){
                return null;
            }else {
                //存在,含义是当前潜水节点已经被访问
                //将这个节点添加到链表末尾
                removeNode(root);
                add(root);
                return root.value;
            }
        }

        //存储一个键值对
        public void put(K key,V value){
            Node<K,V> root = map.get(key);
            if (root == null){
                //不存在这个key
                root = new Node<K,V>(key,value);
                map.put(key,root);
                add(root);
                //超出容量移除头节点
                if (map.size() > cap && head != tail){
                    removeNode(head);
                    map.remove(head.key);
                }
            }else {
                //存在
                removeNode(root);
                add(root);
                root.value = value;
            }
        }
    }
}
