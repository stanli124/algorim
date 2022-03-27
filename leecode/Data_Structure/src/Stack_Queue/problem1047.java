package Stack_Queue;

import java.util.Stack;

public class problem1047 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("ssass"));
    }

    public static  String removeDuplicates(String s) {
        //遍历该字符串，在每次入栈前先判断，若遍历到的当前字符和栈顶元素相同那么先删除栈顶元素，查看下一个栈顶元素是否和
        //当前元素相等，相等就删除，以此类推，直到栈顶元素和当前字符不相等。
        //如果当前字符和栈顶字符不相等就入栈，继续向后遍历。

        Stack<Character> stack = new Stack<>();
        char last = '1';
        for (char c : s.toCharArray()){
            if (stack.isEmpty()) stack.push(c); //栈为空直接添加
            else if (stack.peek() != c){   //栈不为空且当前元素和栈顶元素不相等，直接添加
               stack.push(c);
            }
            else{ //栈不为空，当前元素和栈顶元素相等
                while (!stack.isEmpty() && stack.peek() == c) stack.pop(); //栈顶元素和当前元素相等就出栈。
                last = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }


    //有问题，始终考虑不完所有情况
//    public static  String removeDuplicates(String s) {
//        //遍历该字符串，在每次入栈前先判断，若遍历到的当前字符和栈顶元素相同那么先删除栈顶元素，查看下一个栈顶元素是否和
//        //当前元素相等，相等就删除，以此类推，直到栈顶元素和当前字符不相等。
//        //如果当前字符和栈顶字符不相等就入栈，继续向后遍历。
//
//        Stack<Character> stack = new Stack<>();
////        char last = '1';
////        for (char c : s.toCharArray()){
////            if (stack.isEmpty()) stack.push(c); //栈为空直接添加
////            else if (stack.peek() != c){   //栈不为空且当前元素和栈顶元素不相等，直接添加
////                stack.push(c);
////            }
////            else{ //栈不为空，当前元素和栈顶元素相等
////                while (!stack.isEmpty() && stack.peek() == c) stack.pop(); //栈顶元素和当前元素相等就出栈。
////                last = c;
////            }
////        }
//
//
//        boolean flag = false;
//        for (int i = 0; i < s.length()-1; i++) {
//            if (s.charAt(i) != s.charAt(i+1) && !flag) {
//                if (!stack.isEmpty() && stack.peek()==s.charAt(i)){
//                    while (!stack.isEmpty() && stack.peek() == s.charAt(i)) stack.pop();
//                    continue;
//                }
//                stack.push(s.charAt(i));
//            }
//            else if (s.charAt(i) != s.charAt(i+1) && flag){
//                if (!stack.isEmpty() && stack.peek()==s.charAt(i+1)){
//                    while (!stack.isEmpty() && stack.peek() == s.charAt(i+1)) stack.pop();
//                    continue;
//                }
//                stack.push(s.charAt(i+1));
//            }
//            else{
//                flag = true;
//                continue;
//            }
//        }
//
//
//        StringBuilder sb = new StringBuilder();
//        int len = stack.size();
//        for (int i = 0; i < len; i++) {
//            sb.insert(0, stack.pop());
//        }
//
//        return sb.toString();
//    }

}
