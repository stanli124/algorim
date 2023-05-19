import java.util.ArrayList;

public class NumberOfSegmentsInAString {

    /**
     * 自己的解法
     */
    class Solution {
        public int countSegments(String s) {
            if (s.length() == 0) return 0;
            ArrayList<String> strings = new ArrayList<>();

            int start = 0;
            int end = 0;

            while (start< s.length() && end < s.length()){
                start = end;
                while (start<s.length() && s.charAt(start)==' '){
                    start++;
                }
                end = start;
                while (end < s.length() && s.charAt(end)!=' '){
                    end++;
                }
                if (start < s.length() && end <= s.length())
                    strings.add(s.substring(start, end));

            }
            return strings.size();
        }
    }


    /**
     * 我们可以从前往后处理字符串 s 并进行计数，对于是空格的字符进行跳过（不计数），
     * 而对于非空格字符，则在遍历完一个完整单词（连续一段）后进行一次计数。
     */
    class Solution2 {
        public int countSegments(String s) {
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n; ) {
                if (s.charAt(i) == ' ' && i++ >= 0) continue; //跳过空格字符，此时指向第一个单词的首字符
                while (i < n && s.charAt(i) != ' ') i++; //从单词的首字符开始遍历，当遍历到第一个空格停止，此时遍历完一个完整单词，计数器加1
                ans++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        NumberOfSegmentsInAString segmentsInAString = new NumberOfSegmentsInAString();
        Solution solution = segmentsInAString.new Solution();
        Solution2 solution2 = segmentsInAString.new Solution2();
        System.out.println(solution.countSegments("   "));
        System.out.println(solution2.countSegments("   "));
    }

}
