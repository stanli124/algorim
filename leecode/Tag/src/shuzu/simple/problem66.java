/** 加一
 *  给定一个由 整数 组成的非空数组所表示非负整数，在该数的基础上加1；
 *  最高位数组存放在数组的首位，数组中每个元素只存储单个数字
 *  你可以假设除了整数0之外，这个整数不会以0开头
 */

package shuzu.simple;

public class problem66 {

    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
//        System.out.println(plusOne(digits));
        for (int i : plusOne(digits)) System.out.println(i);
    }

    public static int[] plusOne(int[] digits) {

        int len = digits.length;
        int carry = 0;

        if (digits[len-1] < 9) digits[len-1] = digits[len-1] + 1;  //若最后一位不为9直接加1返回
        else {
            int num = digits[len-1];
            digits[len-1] = (num + carry + 1) % 10;
            carry = (num + carry + 1) / 10;
            for (int i = len-2; i >= 0; i--) {       //若都为9，那么会加到最后所有位都为0，需要在首部位置添加一个1
                num = digits[i];
                digits[i] = (num + carry) % 10;
                carry = (num + carry) / 10;
                if (carry==0) return digits;    //若中间有部分数字不是9加到不是9的就会返回退出
            }
        }
        if (carry==1){
            digits = new int[len+1];
            digits[0] = 1;
        }

        return digits;
    }

}
