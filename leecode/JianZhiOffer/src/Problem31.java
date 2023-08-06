import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem31 {
    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) { // 压入一个数之后，判断stack的栈顶元素是否和出栈数组的首元素相同，若相同则出栈。
                stack.pop();
                popIndex++;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}
