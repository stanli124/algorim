/** 字符串中的第一个唯一字符
 *   给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回-1；
 *
 *  怎么知道该字符是否是不重复的字符，一定要遍历完整个字符串吗
 *
 */

package zifuchuan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day6_1 {

    public static void main(String[] args) {

        String s = "asdasdsadasfwefgefsd";

        long startTime = System.currentTimeMillis();
        System.out.println(firstUniqChar(s));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");

    }

    public static int firstUniqChar(String s) {

        //这个方法通不过；
//        HashSet<String> uniqChar = new HashSet<>();
//
//        if (!s.substring(1).contains(s.subSequence(0,1))) return 0;
//        for (int i = 1; i < s.length()-1; i++) {
//
//
////            System.out.println(s.subSequence(i, i+1));
//////            System.out.println(s.contains(s.subSequence(i,i+1)));
////            System.out.println(s.substring(i+1));
//            if (s.charAt(i)==s.charAt(i-1)) continue;
//            if (!s.substring(i+1).contains(s.subSequence(i,i+1))) return i;
//        }
//
//        return -1;




        //用map记录字符索引和出现次数，从次数为1的里面选择索引最小的；
        /*HashMap<String, Integer> uniqChar = new HashMap();
        int index = Integer.MAX_VALUE;
        int value = 0;

        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.subSequence(i,i+1));
            if (uniqChar.containsKey(s.substring(i,i+1))) uniqChar.put(s.substring(i,i+1), uniqChar.get(s.substring(i,i+1))+1);
            else uniqChar.put(s.substring(i,i+1), 1);
        }

//        Set<String> ss = uniqChar.keySet();
        for (String key: uniqChar.keySet())
        {
            value = uniqChar.get(key);
            if (value == 1){
                index = s.indexOf(key)<index?s.indexOf(key):index;
            }
        }

        if (index==Integer.MAX_VALUE) return -1;
        else return index;*/


        //两次遍历，都遍历字符串；第一次遍历字符串是计算出现次数；第二次遍历字符串，返回第一个次数为的索引；
        HashMap<Character, Integer> uniqChar = new HashMap();
        char c;

        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.subSequence(i,i+1));
            c = s.charAt(i);
            if (uniqChar.containsKey(c)) uniqChar.put(c, uniqChar.get(c)+1);
            else uniqChar.put(c, 1);
        }

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (uniqChar.get(c)==1){
                return s.indexOf(c);
            }
        }

        return -1;


    }

}
