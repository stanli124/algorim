/** 同构字符串
 *  给定两个字符串s和t，判断它们是否是同构的。
 *  如果s中的字符可以按照某种映射关系替换得到t，那么这两个字符串是同构的；
 *  每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */

package zifuchuan;

import java.util.HashMap;

public class problem {

    public static void main(String[] args) {

        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {

        if (s.length()!=t.length()) return false;

        HashMap<Character, Character> charMap = new HashMap<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!charMap.containsKey(ch)) {//不包含当前字符
                if (charMap.containsValue(t.charAt(i))) return false;  //若当前不同字符映射到同一个字符，则返回false；
                charMap.put(ch, t.charAt(i));   //否则添加字符；
            }
            else {    //包含当前字符则检验是否满足条件
                if (charMap.get(ch) != t.charAt(i)) return false;    //相同字符只能映射到同一个字符上;
            }


        }

        return true;
    }

}
