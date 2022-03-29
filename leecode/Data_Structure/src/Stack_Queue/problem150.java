/** 逆波兰表达式求值
 *  根据 逆波兰表达式，求表达式的值
 *  有效的运算符 加减乘除。每个运算对象可以是整数，也可以是另一个逆波兰表达式
 *  注意两个整数之间的除法只保留整数部分
 */

package Stack_Queue;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.Stack;

public class problem150 {

    public static void main(String[] args) {
        String[] strs = {"3","4","-"};
        System.out.println(evalRPN(strs));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")){
                int res = nums.pop() + nums.pop();
                nums.push(res);
            }else if (tokens[i].equals("-")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2 - num1);
            }else if (tokens[i].equals("*")){
                int res = nums.pop() * nums.pop();
                nums.push(res);
            }else if (tokens[i].equals("/")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2 / num1);
            }else {
                nums.push(Integer.valueOf(tokens[i]));
            }

        }

        return nums.pop();
    }

}
