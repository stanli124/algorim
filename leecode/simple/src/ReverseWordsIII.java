public class ReverseWordsIII {

    class Solution{
        public String reverseWords(String s){
            String[] strings = s.split(" ");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strings.length; i++) {
                String str = strings[i];
                for (int j = str.length()-1; j >= 0; j--) {
                    sb.append(str.charAt(j));
                }
                sb.append(' ');
            }

            return sb.deleteCharAt(sb.length()-1).toString();
        }
    }

    public static void main(String[] args) {
        ReverseWordsIII wordsIII = new ReverseWordsIII();
        Solution solution = wordsIII.new Solution();
        System.out.println(solution.reverseWords("God Ding"));
    }

}
