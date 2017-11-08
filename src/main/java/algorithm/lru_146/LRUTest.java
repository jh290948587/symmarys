package algorithm.lru_146;

/**
 * Created by Administrator on 2017/11/1.
 */
public class LRUTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(11,111);
        cache.set(22,222);
        cache.set(33,333);
        cache.set(44,444);
        cache.set(55,555);
        cache.set(66,666);
        int i = cache.get(66);
        System.out.println(i);

    }
}
