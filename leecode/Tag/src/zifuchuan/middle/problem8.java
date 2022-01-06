/** 字符串转换整数
 *  将一个字符串转换成一个32位有符号整数
 */

package zifuchuan.middle;

public class problem8 {

    public static void main(String[] args) {
//"-5-"  "   +0 123"   "00000-42a1234" "+-12"
        System.out.println(myAtoi("   +0 123"));

    }

    public static int myAtoi(String s) {
        int isNegative = 0;
        int isPositive = 0;
        boolean flag= true;
        char ch;
        StringBuilder sb = new StringBuilder();
        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '-' && flag){
                if (sb.length()>0) break;
                isNegative = 1;
                flag=false;
            }
            else if (ch == '+' && flag){
                if (sb.length()>0) break;
                isPositive = 1;
                flag=false;
            }
            else if (ch < 48 || ch > 58){
                break;
            }
            else if (ch >= 48 &&  ch <= 58){
                sb.append(ch);
            }
        }

        if (isNegative==1 && isPositive==1) return 0;


        int idx = 0;
        int len = sb.length();

        while (idx < len){
            if (sb.charAt(idx) == '0'){idx++;}
            else break;
        }

        int atoi = 0;
        if (isNegative==1 && len>0){   //是负数
            for (int i = idx; i <len; i++) {
                atoi+=-Math.pow(10, len-i-1)*(sb.charAt(i)-'0');
                if (atoi <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
        }
        else if (isNegative==0 && len>0) //是正数
            for (int i = idx; i <len; i++) {
                atoi+=Math.pow(10,  len-i-1)*(sb.charAt(i)-'0');
                if (atoi >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }

        return atoi;
    }

}
