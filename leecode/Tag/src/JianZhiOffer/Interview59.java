package JianZhiOffer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//队列的最大值
public class Interview59 {

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        q.isEmpty();
    }
}
//暴力解法
//class MaxQueue {
//    Queue<Integer> q;
//    public MaxQueue() {
//        q = new LinkedList<>();
//    }
//
//    public int max_value() {
//        if (q.isEmpty()) return -1;
//        int max = -1;
//        for(int i : q){
//            if (i > max) max = i;
//        }
//        return max;
//    }
//
//    public void push_back(int value) {
//        q.offer(value);
//    }
//
//    public int pop_front() {
//        if (q.isEmpty()) return -1;
//        return q.poll();
//    }
//}
class MaxQueue {
    Queue<Integer> q;
    PriorityQueue<Integer> p;
    public MaxQueue() {
        q = new LinkedList<>();
        p = new PriorityQueue<Integer>((o1, o2)->o2.compareTo(o1));
    }

    public int max_value() {
        if (q.isEmpty()) return -1;
        return p.poll();
    }

    public void push_back(int value) {
        q.offer(value);
        p.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) return -1;
        p.remove(q.peek());
        return q.poll();
    }
}