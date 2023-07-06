public class Problem58 {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            n = n % s.length();
            StringBuilder sb = new StringBuilder();

            sb.append(s.substring(n, s.length()));
            sb.append(s.substring(0, n));

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Problem58 problem58 = new Problem58();
        Solution solution = problem58.new Solution();
        System.out.println(solution.reverseLeftWords("lrloseumgh", 6));
    }

}
