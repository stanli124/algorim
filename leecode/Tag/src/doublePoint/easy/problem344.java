/** 反转字符串
 *  将输入字符串反转。
 *  原地修改输入数组
 */

package doublePoint.easy;

public class problem344 {

    public static void main(String[] args) {
        reverseString(new char[]{'h','h','h'});
    }

    public static void reverseString(char[] s) {
        int l = 0;
        int r = s.length-1;

        while (l<r){
            char c = s[l];
            s[l++] = s[r];
            s[r--] = c;
        }

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

    }

}
