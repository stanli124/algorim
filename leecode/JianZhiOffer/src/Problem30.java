import java.util.PriorityQueue;
import java.util.Stack;

public class Problem30 {
    public static void main(String[] args) {
        Problem30 problem30 = new Problem30();
        MinStack minStack = problem30.new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    class MinStack {

        PriorityQueue<Integer> compare = new PriorityQueue<>();
        Stack<Integer> stack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            stack.push(x);
            compare.offer(x);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                compare.remove(stack.peek());
                stack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public int min() {
            return compare.peek();
        }
    }

}
