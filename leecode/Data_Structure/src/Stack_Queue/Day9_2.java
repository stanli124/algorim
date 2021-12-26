/** 用栈实现队列
 *  仅使用两个栈实现 先入先出队列。队列应当支持一般队列的所有操作(push、pop、peek、empty)
 *
 *
 */


package Stack_Queue;


import java.util.Stack;

class MyQueue {
    private Stack<Integer> a;
    private Stack<Integer> b;

    public MyQueue() {
        a = new Stack();
        b = new Stack();
    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        //不为空的时候直接pop，若为空则把另一个栈的值全部存入pop栈后再取值；

        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek() {
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty() {
        return b.empty();
    }
}


public class Day9_2 {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(2);
        obj.push(3);
        System.out.println("pop "+obj.pop());
        System.out.println("peek "+obj.peek());
        System.out.println(obj.empty());
    }

}
