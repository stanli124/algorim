import java.util.HashMap;
import java.util.HashSet;

public class wordPattern {

    class Solution {
        /**
         * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
         * @param pattern 指示单词之间关系的字符串，如 "abba" 表示 "dog cat cat dog"这类字符串
         * @param s 包含小写英文单词的字符串，每个单词之间空格相隔
         * @return
         */
        public boolean wordPattern(String pattern, String s) {
            String[] word = s.split(" ");
            if (pattern.length() != word.length) return false;

            HashMap<Character, String> m = new HashMap<>();
            HashSet<Character> cSet = new HashSet<>();
            HashSet<String> wordSet = new HashSet<>();

            for (int i = 0; i < word.length; i++) {
                char c = pattern.charAt(i);
                cSet.add(c);
                wordSet.add(word[i]);
                if (!m.containsKey(c)){
                    m.put(c, word[i]);
                }else {
                    if (!m.get(c).equals(word[i])) return false;
                }
            }

            if (cSet.size() != wordSet.size()) return false;

            return true;
        }
    }

    public static void main(String[] args) {
        wordPattern wordPattern = new wordPattern();
        Solution solution = wordPattern.new Solution();
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }


}
