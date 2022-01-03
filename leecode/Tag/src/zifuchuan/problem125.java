/** 验证回文串
 *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 */

package zifuchuan;

public class problem125 {

    public static void main(String[] args) {

        String s = "0P";
        System.out.println(isPalindrome(s));


    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        if (j==-1) return true;
        s = s.toLowerCase();

        while (i < j){
            if ((s.charAt(i)>=97 && s.charAt(i)<=122) || (s.charAt(i)>=48 && s.charAt(i)<=57)) {
//                if (s.charAt(i)!=s.charAt(j)) return false;
            }
            else {
                i++;
                continue;
            }
            if ((s.charAt(j)>=97 && s.charAt(j)<=122) || (s.charAt(j)>=48 && s.charAt(j)<=57)) {
//                if (s.charAt(i)!=s.charAt(j)) return false;
            }
            else {
                j--;
                continue;
            }


            if (s.charAt(i) != s.charAt(j)){
                return false;
            }else {
                i++;
                j--;
            }

        }
        return true;
    }

}
