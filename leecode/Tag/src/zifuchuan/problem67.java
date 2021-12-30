/** 二进制求和
 *  给你两个字符串，返回它们的和；以二进制表示；
 *
 */

package zifuchuan;

public class problem67 {

    public static void main(String[] args) {
        String s1="110010";
        String s2="10111";



        System.out.println(addBinary(s1, s2));

    }

    public static String addBinary(String a, String b) {

        //对于大数值不行；
//        long sum = 0;
//        int mi = 0;
//
//        for (int i = a.length()-1; i >= 0; i--) {
//            if (a.charAt(i)=='1')
//                sum+=Math.pow(2, mi);
//            else
//                sum+=0;
//            mi++;
//        }
//
//        mi=0;
//        for (int i =b.length()-1; i >= 0; i--) {
//            if (b.charAt(i)=='1')
//                sum+=Math.pow(2, mi);
//            else
//                sum+=0;
//            mi++;
//        }
//        return Long.toBinaryString(sum);


        //完全错误的做法
//        int aLen = a.length()-1;
//        int bLen = b.length()-1;
//        StringBuffer binarySum = new StringBuffer();
//        char aChar;
//        char bChar;
//        char jinWei = '0';
//
//        for (; aLen>=0 && bLen>=0 ; aLen--,bLen--) {
//            aChar = a.charAt(aLen);
//            bChar = b.charAt(bLen);
//            if (aChar=='1' && bChar=='1' && jinWei=='0'){
//                binarySum.insert(0, '0');
//                jinWei = '1';
//            }
//            else if (aChar=='1' && bChar=='1' && jinWei=='1'){
//                binarySum.insert(0, '1');
//                jinWei = '1';
//            }
//            else if (aChar=='0' && bChar=='0' && jinWei=='1'){
//                binarySum.insert(0, '1');
//                jinWei = '0';
//            }
//            else if (aChar=='0' && bChar=='0' && jinWei=='0'){
//                binarySum.insert(0, '0');
//            }
//            else if (aChar=='1' && bChar=='0' && jinWei=='1'){
//                binarySum.insert(0, '0');
//                jinWei = '0';
//            }
//            else if (aChar=='0' && bChar=='1' && jinWei=='1'){
//                binarySum.insert(0, '0');
//                jinWei = '0';
//            }
//            else if (aChar=='1' && bChar=='0' && jinWei=='0'){
//                binarySum.insert(0, '1');
//                jinWei = '0';
//            }
//            else if (aChar=='0' && bChar=='1' && jinWei=='0'){
//                binarySum.insert(0, '1');
//                jinWei = '0';
//            }
//        }
//
//        if (bLen==aLen){
//            if (jinWei=='1') binarySum.insert(0, '1');
//            return binarySum.toString();
//        }
//
//        if (bLen >= 0){
//            if (jinWei=='0') binarySum.insert(0, b.substring(0, bLen+1));
//            else {
//                for (; bLen >= 0 ; bLen--) {
//                    bChar = b.charAt(bLen);
//                    if (bChar=='0' && jinWei=='1'){
//                        jinWei='0';
//                        binarySum.insert(0, '1');
//                    }
//                    else if (bChar=='1' && jinWei=='1'){
//                        jinWei='1';
//                        binarySum.insert(0, '0');
//                    }
//                    else if (bChar=='0' && jinWei=='0'){
//                        binarySum.insert(0, '0');
//                    }
//                    else if (bChar=='1' && jinWei=='0'){
//                        binarySum.insert(0, '1');
//                    }
//
//                }
//            }
//        }
//
//        if (aLen >= 0){
//            if (jinWei=='0') binarySum.insert(0, a.substring(0, aLen+1));
//            else {
//                for (; aLen >= 0 ; aLen--) {
//                    aChar = a.charAt(aLen);
//                    if (aChar=='0' && jinWei=='1'){
//                        jinWei='0';
//                        binarySum.insert(0, '1');
//                    }
//                    else if (aChar=='1' && jinWei=='1'){
//                        jinWei='1';
//                        binarySum.insert(0, '0');
//                    }
//                    else if (aChar=='0' && jinWei=='0'){
//                        binarySum.insert(0, '0');
//                    }
//                    else if (aChar=='1' && jinWei=='0'){
//                        binarySum.insert(0, '1');
//                    }
//
//                }
//            }
//        }
//
//        if (jinWei=='1') binarySum.insert(0, '1');
//        return binarySum.toString();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();

    }

}
