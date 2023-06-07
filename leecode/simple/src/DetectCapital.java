public class DetectCapital {

    class Solution{
        /**
         * 全部字母都是大写，比如 "USA" 。
         * 单词中所有字母都不是大写，比如 "leetcode" 。
         * 如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
         * @param word 输入的字符串
         * @return 返回是否满足大写写法
         */
        public boolean detectCapitalUse(String word){
            boolean capital = true;
            boolean allUpperCase = true;
            boolean allLowwerCase = true;

            //检测是否是全小写或全大写
            for (int i = 0; i < word.length(); i++) {
                //'A'~'Z'的ascii码是65到90 'a'~'z'的ascii码值是97到122
                if (word.charAt(i) - 'a' < 0){
                    allLowwerCase = false;
                }
                //检测是否全大写
                if (word.charAt(i) - 'a' >= 0) allUpperCase = false;
                //检测是否只有首字符大写
                if (i==0 && word.charAt(0)-'a'>=0) capital = false;
                if (i>0 && word.charAt(i)-'a' < 0) capital = false;
            }

            return capital || allLowwerCase || allUpperCase;

        }
    }

    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        Solution solution = detectCapital.new Solution();
        System.out.println(solution.detectCapitalUse("Google"));
    }


}
