/** 最后一个单词的长度
 *  给你一个字符串s，由若干单词，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *  单词是指仅由字母组成、不包含任何空格字符的最大子字符串；
 *
 */

package zifuchuan;

public class problem58 {

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {

        //借助一个SB构造保存单词字符
//        StringBuffer lastWord = new StringBuffer();
//        s = s.trim();
//
//        for (int i = s.length()-1; i >=0 ; i--) {
//            if (s.charAt(i)!=' '){
//                lastWord.insert(0, s.charAt(i));
//            }else return lastWord.length();
//        }
//        return lastWord.length();

        int index = s.length() - 1;
        while (s.charAt(index)==' ') index--; //去掉最后的空格字符；

        int wordLen = 0;
        while (index>=0 && s.charAt(index)!=' '){
            wordLen++;
            index--;
        }
        return wordLen;
    }

}
