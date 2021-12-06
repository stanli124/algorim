/**
 * 题目：1816.截断句子
 * 输入单词列表，列表中的单词使用单个空格相隔，不存在前后空格，不含标点符号
 *
 */

public class Cutsentence {
    public static void main(String[] args) {
        String s = "hello how are you Contestant";
        System.out.println(truncateSentence(s, 4));
    }

    //使用+来连接字符串的效率最低
//    public static String truncateSentence(String s, int k) {
//        String[] split_s = s.split(" ");
//
//        Integer len_s = split_s.length;
//
//        String cut_sentence = "";
//
//        if (k <= len_s){
//            for (int i = 0; i < k-1; i++) {
//                cut_sentence = cut_sentence + split_s[i] + " ";
//            }
//            cut_sentence = cut_sentence + split_s[k-1];
//        }
//        return cut_sentence;
//    }

    //concat的方式比+的方式快了3倍
    public static String truncateSentence(String s, int k) {
        String[] split_s = s.split(" ");

        Integer len_s = split_s.length;

        String cut_sentence = "";

        if (k <= len_s){
            for (int i = 0; i < k-1; i++) {
                cut_sentence = cut_sentence.concat(split_s[i] + " ");
            }
            cut_sentence = cut_sentence.concat(split_s[k-1]);
        }
        return cut_sentence;

    }

}
