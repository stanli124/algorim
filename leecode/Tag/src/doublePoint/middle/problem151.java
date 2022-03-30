/** 颠倒字符串中的单词
 *  给定一个字符串，颠倒字符串中单词的顺序
 */

package doublePoint.middle;

public class problem151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length()-1;

        int start = -1;
        int end = -1;
        for (int i = n; i >= 0; i--) {
            if (s.charAt(i)==' ') continue;
            else {
                end = i;
                while (i >= 0 && s.charAt(i)!=' ') i--;
                start = i+1;
                sb.append(s.substring(start, end+1)+" ");
            }
        }

        return sb.toString().trim();
    }

}
