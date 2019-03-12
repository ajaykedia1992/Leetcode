/*
 * https://medium.com/@nanofaroque/lfu-cache-in-o-1-in-java-4bac0892bdb3
 */

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

	Map<Integer, Integer> vals; // store key and value
    Map<Integer, Integer> counter; // store key and their count
    Map<Integer, LinkedHashSet<Integer>> lists; // count and the list of keys

    int capacity, min;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        min = -1;
        vals = new HashMap<>();
        counter = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key)){
            return -1;
        }
        
        int count = counter.get(key);
        counter.put(key, count + 1);
        lists.get(count).remove(key);
        
        if(count == min && lists.get(count).size() == 0){
            min++;
        }
        
        if(!lists.containsKey(count + 1)){
            lists.computeIfAbsent(count + 1, l -> new LinkedHashSet<Integer>());
        }
        
        lists.get(count + 1).add(key);
        return vals.get(key);
        
    }
    
    public void put(int key, int value) {
        
        if(capacity <= 0){
            return;
        }
        
        if(vals.containsKey(key)){
            vals.put(key, value);
            get(key);
            return;
        }
        
        if(capacity <= vals.size()){
            int evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            counter.remove(evict);
            vals.remove(evict);
        }
        
        vals.put(key, value);
        min = 1;
        counter.put(key, 1);
        lists.get(1).add(key);
        
    }

	public static void main(String[] args) {

		LFUCache cache = new LFUCache(2);
		cache.put(1,1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}
}
