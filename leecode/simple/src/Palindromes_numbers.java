import javax.swing.table.TableRowSorter;

public class Palindromes_numbers {

    public static void main(String[] args) {
        int x = 2147483647;
        long startTime = System.currentTimeMillis();
        System.out.println(isPalindrome(x));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }

    public static boolean isPalindrome(int x) {
        //构造一个正序字符串和逆序字符串，对比是否相等；
//        String x_str = String.valueOf(x);
//        StringBuffer x_str_inverse = new StringBuffer();
//
//        for (int i = x_str.length()-1; i>=0; i--) {
//            x_str_inverse.append(x_str.charAt(i));
//        }
//        System.out.println(x_str);
//        System.out.println(x_str_inverse.toString());
//        return x_str.equals(x_str_inverse.toString());



        //从字符串的两头向中间遍历，如果是回文数字，则两头的数字都一样；若两头的字符不一样的话，那么就不是回文字符串；
//        String x_str = String.valueOf(x);
//        int head = 0;
//        int tail = x_str.length()-1;
//
//        while (head<=tail){
//            if (x_str.charAt(head) == x_str.charAt(tail)){
//                head++;
//                tail--;
//            }
//            else return false;
//        }
//        return true;


        //使用纯数字方法
        if (x==0) return true;
        if (x<0 || x%10==0) return false;
        long inver_num = 0;
        long x_ = x;

        while (inver_num < x){
            inver_num = inver_num * 10 + x_%10;
            x_ = x_ / 10;
        }

        return x==inver_num;

    }

}
