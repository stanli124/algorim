import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem59 {

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
//        System.out.println(obj.max_value());
//        obj.push_back(1);
//        obj.push_back(2);
//        System.out.println(obj.max_value());
//        System.out.println(obj.pop_front());
//        System.out.println(obj.max_value());

        System.out.println(obj.pop_front());
        System.out.println(obj.pop_front());
        System.out.println(obj.pop_front());
        System.out.println(obj.pop_front());
        System.out.println(obj.pop_front());
        obj.push_back(15);
        System.out.println(obj.max_value());
        obj.push_back(9);
        System.out.println(obj.max_value());

    }

}

class MaxQueue {


    Queue<Integer> q1 = new LinkedList<Integer>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((num1, num2)->{
         return num2 - num1;
     });

    public MaxQueue() {

    }

    public int max_value() {
        if (q1.isEmpty()) return -1;
        return maxQueue.peek();
    }

    public void push_back(int value) {
        q1.offer(value);
        maxQueue.offer(value);
    }

    public int pop_front() {
        if (q1.isEmpty()) {
            return -1;
        }
        maxQueue.remove(q1.peek());
        return q1.poll();
    }
}

