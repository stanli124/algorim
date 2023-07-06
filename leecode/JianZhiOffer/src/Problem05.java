public class Problem05 {

    class Solution {
        public String replaceSpace(String s) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') sb.append(s.charAt(i));
                else
                    sb.append("%20");
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Problem05 problem05 = new Problem05();
        Solution solution = problem05.new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }

}
