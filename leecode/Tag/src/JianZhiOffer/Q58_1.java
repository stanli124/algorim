package JianZhiOffer;

public class Q58_1 {
    //翻转单词顺序

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {

        s = s.trim();
        StringBuffer sb = new StringBuffer();

        for (String str : s.split(" ")){
            if (str.equals("")) continue;
            sb.insert(0, str + " ");
        }
        return sb.toString().trim();

    }

}
