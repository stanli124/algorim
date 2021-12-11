/**
 * 给定一个32位的有符号整数，返回将x中的数字部分反转后的结果；
 * 若反转后的整数超过32位有符号整数的范围就返回0
 */


public class Integer_reverse {
    public static void main(String[] args) {
        System.out.println(StrictMath.pow(-2,31));
//        System.out.println((int)StrictMath.log10(StrictMath.abs(1)) + 1);
        System.out.println(reverse(-123));
    }

    public static int reverse(int x){

        int digits; //保存位数
        if (x < 0) {
            int abs_x = StrictMath.abs(x);
            digits = (int)StrictMath.log10(abs_x) + 1;
            int[] numbers_in_different_digits = new int[digits];  //保存每一位的数字
            int results = 0;

            for (int i = digits-1; i >= 0 ; i--) {
                int temp = (int)StrictMath.pow(10, i);
                int sum = 0;
                for (int j = 0; j<digits; j++) {sum += numbers_in_different_digits[j] * StrictMath.pow(10, j);}
                numbers_in_different_digits[i]  = (int)((abs_x - sum) / temp);
            }
//            for (int i = 0; i < digits ; i++) {results += -StrictMath.pow(10, digits-1-i)*numbers_in_different_digits[i];}
//            if (results<=-2147483648) return 0;
//            return results;

            for (int i = 0; i < digits ; i++) {results += StrictMath.pow(10, digits-1-i)*numbers_in_different_digits[i];}
            if (-results<=-2147483648) return 0;
            return -results;

        }
        else if (x == 0 ) return x;
        else {
            digits = (int)StrictMath.log10(x) + 1;
            System.out.println("digits "+digits);
            int[] numbers_in_different_digits = new int[digits];  //保存每一位的数字
            int results = 0;

            for (int i = digits-1; i >= 0 ; i--) {
                int temp = (int)StrictMath.pow(10, i);
                int sum = 0;
                for (int j = 0; j<digits; j++) {sum += numbers_in_different_digits[j] * StrictMath.pow(10, j);}
                numbers_in_different_digits[i]  = (int)((x - sum) / temp);
                System.out.print(i +" ");
                System.out.println(numbers_in_different_digits[i]);
            }

            for (int i = 0; i < digits ; i++) {results += StrictMath.pow(10, digits-1-i)*numbers_in_different_digits[i];}
            if (results>=2147483647) return 0;

            return results;
        }

    }
}
