package hot100.middle;

import java.nio.file.Paths;
import java.util.Stack;

public class problem394 {

    public static void main(String[] args) {
        String s = "100[lee]";
        problem394 a = new problem394();
        System.out.println(a.decodeString(s));
    }

    public String decodeString(String s) {
        Stack<String> charS = new Stack<>();
        Stack<Integer> numS = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int index = i;
                while (index<s.length()){
                    if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                        index++;
                    }else{
                        break;
                    }
                }
                if (index > i){
                    numS.add(Integer.valueOf(s.substring(i, index)));
                    i = index-1;
                }else
                    numS.add(Integer.valueOf(c - '0'));
            }
            else if (c >= 'a' && c <= 'z' || c == '[') charS.add(s.substring(i, i + 1));
            else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                String temp = charS.pop();
                while (!charS.empty() && !charS.peek().equals("[")) {
                    temp = charS.pop() + temp;
                }
                //把[出栈
                charS.pop();
                int count = numS.pop();
                for (int j = 0; j < count; j++) {
                    sb.insert(0, temp);
                }
                charS.push(sb.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while (!charS.empty()) {
            res.insert(0, charS.pop());
        }
        return res.toString();
    }

}
