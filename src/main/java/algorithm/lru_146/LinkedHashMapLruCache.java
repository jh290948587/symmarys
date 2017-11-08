package algorithm.lru_146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/1.
 */
public class LinkedHashMapLruCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LinkedHashMapLruCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        Integer integer = map.get(key);
        if(integer != null){
            return integer;
        }else{
            return -1;
        }
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
}
