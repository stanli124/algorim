package JianZhiOffer;

import java.util.LinkedList;
import java.util.Queue;

//队列的最大值
public class Interview59 {

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        q.isEmpty();
    }
}
class MaxQueue {
    Queue<Integer> q;
    public MaxQueue() {
        q = new LinkedList<>();
    }

    public int max_value() {
        if (q.isEmpty()) return -1;
        int max = -1;
        for(int i : q){
            if (i > max) max = i;
        }
        return max;
    }

    public void push_back(int value) {
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) return -1;
        return q.poll();
    }
}