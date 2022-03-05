/** 两数相除
 *  给定两个整数，被除数和除数。将两个数相除，要求不能使用乘法、除法、mod运算。
 */

public class problem29 {

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println((int)Math.pow(2, 31));


        System.out.println(divide(10, 2));

    }


//    public static int divide(int dividend, int divisor) {
//        if (dividend == Integer.MIN_VALUE) {
//            if (divisor == 1) {
//                return Integer.MIN_VALUE;
//            }
//            if (divisor == -1) {
//                return Integer.MAX_VALUE;
//            }
//        }
//        // 考虑除数为最小值的情况
//        if (divisor == Integer.MIN_VALUE) {
//            return dividend == Integer.MIN_VALUE ? 1 : 0;
//        }
//
//
//        boolean flag = false;
//        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) flag = true; //表明结果为负数；
//        dividend = Math.abs(dividend);
//        divisor = Math.abs(divisor);
//
//        int shang = 0;
//        for (;dividend >= 0;) {
//            dividend = dividend - divisor;
//            if (dividend >= 0){
//                shang++;
//            }else {
//                break;
//            }
//        }
//
//        if (shang > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        return flag?-shang : shang;
//    }


    public static int divide(int dividend, int divisor){
//        if (dividend == Integer.MIN_VALUE) {
//            if (divisor == 1) {
//                return Integer.MIN_VALUE;
//            }
//            if (divisor == -1) {
//                return Integer.MAX_VALUE;
//            }
//        }
//        // 考虑除数为最小值的情况
//        if (divisor == Integer.MIN_VALUE) {
//            return dividend == Integer.MIN_VALUE ? 1 : 0;
//        }
//
//        boolean flag = false;
//        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) flag = true; //表明结果为负数；
//
//        if (dividend > 0) dividend = -dividend;
//        if (divisor > 0) divisor = -divisor;
//
//        int shang = 0;
//        for (;dividend <= 0;){
//            dividend = dividend - divisor;
//            if (dividend <= 0)
//                shang++;
//        }
//
//        if (!flag && shang==Integer.MIN_VALUE) return Integer.MAX_VALUE;
//
//        return flag?-shang:shang;
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}
