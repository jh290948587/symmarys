package algorithm.lru_146;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/1.
 */
public class LRUCache {
    private class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0, 0);
        }
    }
    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<Integer, Node>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }

    public void set(int key, int value) {
//        从map中获取当前key的node节点
        Node n = map.get(key);
//        如果为null，说明没有添加过。添加到head节点后，并且count+1
//        如果不为null，说明添加过，直接更新一下
        if(null==n){
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            ++count;
        } else{
            n.value = value;
            update(n);
        }
//        如果数量大于容量了,把tail的pre删除,count-1即可
        if(count>capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }

    private void update(Node node){
        remove(node);
        add(node);
    }
    private void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }

    public void testNode(){
        Node n = new Node();
        System.out.println(n);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(11,111);
        cache.set(22,222);
        int i = cache.get(11);
        cache.set(33,333);
        cache.set(44,444);
        int i1 = cache.get(33);
    }
}
