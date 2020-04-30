import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {

    private Map<Integer, Integer> cache;
    private LinkedList<Integer> queue;

    private int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){
            queue.remove(key);
            queue.add(key);
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.size() < capacity) {
            cache.put(key, value);
            queue.add(key);
        }else{
            int keyToRemove = queue.poll();
            cache.remove(keyToRemove);
            cache.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */