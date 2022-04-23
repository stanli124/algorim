/**
 * 单词拆分
 * 给定一个字符串s，一个字符串列表wordDict作为字典。
 * 请判断是否可以利用字典中出现的单词拼接出s。
 */

package zifuchuan.middle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class problem139 {

    int[] memo;
    static boolean finded = false;
    public static void main(String[] args) {
        String s = "catsandog";
//        List<String> wordDict = new LinkedList<>(Arrays.asList(
//                "cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"));
        List<String> wordDict = new LinkedList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));

        problem139 problem139 = new problem139();
        problem139.wordBreak(s, wordDict);
        System.out.println(finded);
    }


      //字符串长了会超时
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        wordBreak(s, wordDict, "");
//        return finded;
//
//    }
//
//    public static void wordBreak(String s, List<String> wordDict, String join) {
//        if (s.equals(join)){
//            finded = true;
//            return;
//        }
//        if (finded) return;
//        if (join.length() >= s.length()) return;
//
//        for (int i = 0; i < wordDict.size(); i++) {
//            wordBreak(s, wordDict, join+wordDict.get(i));
//        }
//
//    }


    public boolean wordBreak(String s, List<String> wordDict) {
        // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        // 根据函数定义，判断 s[0..] 是否能够被拼出
        return dp(s, 0, wordDict);
    }

    // 定义：返回 s[i..] 是否能够被 wordDict 拼出
    boolean dp(String s, int i, List<String> wordDict) {
        // base case，整个 s 都被拼出来了
        if (i == s.length()) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 1 ? true : false;
        }
        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            String subStr = s.substring(i, i + len);
            if (!subStr.equals(word)) {
                continue;
            }
            // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出，将结果记入备忘录
                memo[i] = 1;
                return true;
            }
        }
        // s[i..] 不能被拼出，结果记入备忘录
        memo[i] = 0;
        return false;
    }

}
