/** 有效的字母异位词
 *  给定两个字符串 s 和 t；编写一个函数判断t是否是s的字母异位词
 *  Note：若s和t中每个字符出现的次数都相同，则称s和t互为字母异位词；
 *
 */

package zifuchuan;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day6_3 {

    public static void main(String[] args) {
        String s = "asd";
        String t = "das";

        long startTime = System.currentTimeMillis();
        System.out.println(isAnagram(s, t));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }

    public static boolean isAnagram(String s, String t) {

//        HashMap<Character, Integer> c_s = new HashMap<>();
//        HashMap<Character, Integer> c_t = new HashMap<>();
//        char c;
//
//
//        for (int i = 0; i < s.length(); i++) {
//            c = s.charAt(i);
//            if (c_s.containsKey(c)) c_s.put(c, c_s.get(c)+1);
//            else c_s.put(c, 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            c = t.charAt(i);
//            if (c_t.containsKey(c)) c_t.put(c, c_t.get(c)+1);
//            else c_t.put(c, 1);
//        }
//
//        if (c_s.size() != c_t.size()) return false;  //两个分别保存了字符及字符相应的出现次数；如果两个的长度不一致，说明有一个字符串缺少字符或者多字符；
//
//
//
//        //Integer是引用对象，如果比较两个Integer对象会返回false；因为两个对象存的是引用，没有一样的引用；
//        for (Character cc : c_s.keySet()){
//            if ((!c_t.containsKey(cc)) || (c_s.get(cc).intValue()!=c_t.get(cc).intValue())) return false;
//        }
//
//        return true;


        //先排序，因为相同字符会出现一样的次数；那么如果排序后的字符串不相等，那么返回false；

        if (s.length()!=t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

}
