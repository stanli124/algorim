/** 用队列实现栈
 *  仅使用两个队列实现一个后入先出的栈，并支持普通栈的四种操作。
 *  push、top、pop、empty
 */

package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class problem225 {



    public static void main(String[] args) {
        MyStack o = new MyStack();
        o.push(1);
        o.push(2);
        int n1 = o.pop();
        int n2 = o.pop();
        System.out.println(n1 + " " + n2);
        System.out.println(o.empty());
    }

}


class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        if (!q2.isEmpty()){
            while (!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
        q1.offer(x);
    }

    public int pop() {
        if (q1.isEmpty() && !q2.isEmpty()){
            while (!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
        if (q1.size() > 1){
            while (q1.size()>1){
                q2.offer(q1.poll());;
            }
        }
        return q1.poll();

    }

    public int top() {
        if (q1.isEmpty() && !q2.isEmpty()){
            while (!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
        if (q1.size() > 1){
            while (q1.size()>1){
                q2.offer(q1.poll());;
            }
        }
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}