public class IsSubsequence {

    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.equals("") || t.equals("")) return false;
            int curCharIndex = 0;
            int countChar = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = curCharIndex; j < t.length(); j++) {
                    if (s.charAt(i) == t.charAt(j)){ //当前字符相等，设置下一个字符的起始遍历位置
                        curCharIndex = j+1; //加1是避免子序列有连续相同字符，这样在j处连续相同字符会和t中的同一个字符判断相等
                        countChar++; //记录匹配的字符个数
                        break; //开始匹配下一个字符
                    }
                }
            }
            if (countChar == s.length()) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        Solution solution = isSubsequence.new Solution();
        System.out.println(solution.isSubsequence("aa","sadsakc"));
    }

}
