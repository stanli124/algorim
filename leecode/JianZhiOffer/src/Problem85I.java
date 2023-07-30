public class Problem85I {

    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] strs = s.split(" ");

            StringBuilder sb = new StringBuilder();

            for (int i = strs.length-1; i >= 0; i--) {
                if (strs[i].equals("")) continue;
                sb.append(strs[i].trim() + " ");
            }
            return sb.toString().trim();
        }
    }

    public static void main(String[] args) {
        Problem85I problem85I = new Problem85I();
        Solution solution = problem85I.new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }

}
