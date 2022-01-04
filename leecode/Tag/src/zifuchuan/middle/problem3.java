/** 无重复字符的最长子串
 *  给定一个字符串s，请你找出其中不含有重复字符的 最长子串的 长度；
 */


package zifuchuan.middle;

import java.util.HashMap;
import java.util.HashSet;

public class problem3 {


    public static void main(String[] args) {

        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));



    }

    public static int lengthOfLongestSubstring(String s) {
//        if (s.length()==0) return 0;
//        int count = 0;
//        int maxLen = -1;
//
//        HashSet<Character> longestSubstring = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (!longestSubstring.add(s.charAt(i))){
//                if (count > maxLen) {
//                    maxLen = count;
//                }
//                i=i-1;
//                count = 0;
//                longestSubstring.clear();
////                longestSubstring.add(s.charAt(i)); //
////                count++;
//            }
//            else count++;
//
//        }
//        if (count>maxLen) maxLen = count;
//        return maxLen;


        //用hashmap记录字符及其对应的索引；
//        if (s.length() == 0) return 0;
//        int maxLen = -1;
//        int i = 0;
//        char ch;
//
//        HashMap<Character, Integer> charToIndex = new HashMap<>();
//        while (i < s.length()) {
//            ch = s.charAt(i);
//            if (!charToIndex.containsKey(ch)){   //不包含当前字符，则添加该字符及其索引；
//                charToIndex.put(ch, i);
//                i++;
//            }else { //包含当前字符，
//                if (charToIndex.size() > maxLen) maxLen = charToIndex.size();
//                i=charToIndex.get(ch)+1;
//                charToIndex.clear();
//            }
//        }
//
//        if (charToIndex.size() > maxLen) maxLen = charToIndex.size();
//        return maxLen;


        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0;  //窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);    //i位置上的字符；
            start = Math.max(start, last[index] + 1);  //当前字符上一次出现的下一个位置
            res   = Math.max(res, i - start + 1);  //记录当前子串的最大长度；
            last[index] = i;  //记录当前字符的出现位置；
        }
        return res;



    }

}
