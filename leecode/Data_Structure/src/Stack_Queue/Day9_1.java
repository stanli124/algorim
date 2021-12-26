/** 有效的括号
 *  给定一个只包括()、{}、[]的字符串s，判断字符串是否有效；
 *  有效字符串必须满足：
 *  1.左括号必须用相同类型的右括号闭合
 *  2.左括号必须以正确的顺序闭合
 */


package Stack_Queue;

import sun.rmi.transport.proxy.CGIHandler;

import java.util.HashMap;
import java.util.Stack;

public class Day9_1 {

    public static void main(String[] args) {

        String s = "())))";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {

        //使用map保存映射，使用stack来保存运算符
//        int len = s.length();
//        if (len==0) return true;
//
//        //可以使用int数组来保存这些字符；
//        HashMap<Character, Character> leftBrackets = new HashMap<>();
//        Stack<Character> brackets = new Stack<>();
//        char c;
//        leftBrackets.put('(',')');
//        leftBrackets.put('[',']');
//        leftBrackets.put('{','}');
//
//
//        for (int i = 0; i < len; i++) {
//            c = s.charAt(i);
//            if (leftBrackets.containsKey(c)) brackets.push(c);  //如果是左括号就入栈；
//            else { //如果是右括号就取出栈顶元素 和 当前元素进行比较
////                if (brackets.empty()) return false; //有右括号，但是栈中左括号已经没了，则返回false；
//                if ( brackets.empty() || !(leftBrackets.get(brackets.peek()) == c)) return false;
//                brackets.pop();
//            }
//        }
//
//        if (!brackets.empty()) return false; //整个括号字符串已经走完了，还有元素，那么表示还有括号没有匹配完成，返回false；
//        return true;


        //只使用一个stack
        Stack<Character> brackets = new Stack<>();
        for (char c : s.toCharArray()){
            if (c=='(') brackets.push(')');
            else if (c=='[') brackets.push(']');
            else if (c=='{') brackets.push('}');
            else {
                if (brackets.empty() || brackets.pop()!=c) return false;
            }
        }

        return brackets.isEmpty();


        //还有一种解法，使用字符串替换的方法，把这种()成对的括号对替换为""，那么到最后符合规则的字符串会变为"";
    }


}
