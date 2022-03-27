package Stack_Queue;

import java.util.HashMap;
import java.util.Stack;

public class problem20 {

    public static void main(String[] args) {

        System.out.println(isValid("(("));

    }

    public static boolean isValid(String s) {
        if (s.length()%2==1 || s.length() == 0) return false; //如果是奇数长度的字符串那么一定是非法的
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]); //是左括号就入栈
            }else {
                if (stack.isEmpty()) return false; //这时候匹配到了右括号，需要去栈中取左括号；若为空说明没有左括号匹配为非法表达式
                char c = stack.pop();
                if (map.get(chars[i])!=c) return false; //栈中有左括号，但是和当前右括号不匹配，则返回
            }
        }

        return stack.isEmpty(); //若字符串遍历完还有字符，那么是多余的未匹配上的，那么返回false
    }

}
