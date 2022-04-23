/**LRU缓存
 * 设计一个满足LRU（最近最少使用）缓存约束的数据结构
 * get和put函数必须为O(1)的操作
 */

package LRU;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

    class State{
        int key;
        String updateTime;

        public State(int key, String updateTime) {
            this.key = key;
            this.updateTime = updateTime;
        }
    }

    public ConcurrentHashMap<Integer, Integer> cache;
    public ConcurrentHashMap<Integer, State> timeCache;
    public PriorityQueue<State> s = new PriorityQueue<>((a,b)->{
        return a.updateTime.compareTo(b.updateTime);
    });
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        timeCache = new ConcurrentHashMap<>(capacity);
        cache = new ConcurrentHashMap<>(capacity);
    }

    public int get(int key) {
        //访问一次需要增加访问次数
        s.remove(timeCache.get(key));
        timeCache.remove(key);

        State time = new State(key, String.valueOf(System.currentTimeMillis()/3600));

        timeCache.put(key, time);
        s.offer(time);




        return cache.containsKey(key) ? cache.get(key):-1;
    }

    public void put(int key, int value) {
        if (cache.size() == capacity){
            delete(key, value); //超过容量要删除最久未使用的
        }
        //向队列中添加键及对应时间
        State time = new State(key, String.valueOf(System.currentTimeMillis()/3600));
        timeCache.put(key, time);
        s.offer(time);
        cache.put(key, value);
    }

    public void delete(int key, int value){
        if (cache.containsKey(key)){
            cache.put(key, value);

            s.remove(timeCache.get(key));
            timeCache.remove(key);

            State time = new State(key, String.valueOf(System.currentTimeMillis()/3600));

            timeCache.put(key, time);
            s.offer(time);
        }else {
            State state = s.poll();
            int k = state.key;
            cache.remove(k);
            timeCache.remove(k);
        }

    }

}



//对头就是最不常用的
//class LRUCache {
//    int cap;
//    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
//    public LRUCache(int capacity) {
//        this.cap = capacity;
//    }
//
//    public int get(int key) {
//        if (!cache.containsKey(key)) {
//            return -1;
//        }
//        // 将 key 变为最近使用
//        makeRecently(key);
//        return cache.get(key);
//    }
//
//    public void put(int key, int val) {
//        if (cache.containsKey(key)) {
//            // 修改 key 的值
//            cache.put(key, val);
//            // 将 key 变为最近使用
//            makeRecently(key);
//            return;
//        }
//
//        if (cache.size() >= this.cap) {
//            // 链表头部就是最久未使用的 key
//            int oldestKey = cache.keySet().iterator().next();
//            cache.remove(oldestKey);
//        }
//        // 将新的 key 添加链表尾部
//        cache.put(key, val);
//    }
//
//    private void makeRecently(int key) {
//        int val = cache.get(key);
//        // 删除 key，重新插入到队尾
//        cache.remove(key);
//        cache.put(key, val);
//    }
//}
// 详细解析参见：
// https://labuladong.github.io/article/?qno=146

