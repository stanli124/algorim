package stack.simple;

import java.util.PriorityQueue;
import java.util.Stack;

public class problem155 {

    public static void main(String[] args) {

    }


}


class MinStack {

    Stack<Integer> stack = new Stack<>();
    PriorityQueue<Integer> order = new PriorityQueue<>((num1, num2)->{
        //这里不能直接返回差值，会超出表数范围
        if (num1 > num2)
            return 1;
        else if (num1 == num2)
            return 0;
        else return -1;

    });

    public MinStack() {

    }

    public void push(int val) {
        order.offer(val);
        stack.push(val);
    }

    public void pop() {
//        stack.pop();
        order.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return order.peek();
    }

}