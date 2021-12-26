/** Bigram分词
 *  给定第一个词first，第二个词second，考虑某些文本text可能以first second third形式出现的情况，second紧随first，third紧随second
 */


package code;

import java.util.ArrayList;
import java.util.List;

public class Bigram_cut_word {

    public static void main(String[] args) {

        String f="a";
        String s="good";
        String text="alice is a good girl she is a good student";

        System.out.println(findOcurrences(text, f, s)[0]);

    }

    public static String[] findOcurrences(String text, String first, String second) {

        List<String> third = new ArrayList<>();
        String[] sp_text = text.split(" ");

        for (int i = 0; i < sp_text.length-2; i++) {
            if (sp_text[i].equals(first) && sp_text[i+1].equals(second)){
                third.add(sp_text[i+2]);
            }
        }

//        String[] th = new String[third.size()];
//        for (int i = 0; i < third.size(); i++) {
//            th[i] = third.get(i);
//        }

        return third.toArray(new String[0]);

    }

}
