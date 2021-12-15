public class Palindromes_numbers {

    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        String x_str = String.valueOf(x);
        StringBuffer x_str_inverse = new StringBuffer();

        for (int i = x_str.length()-1; i>=0; i--) {
            x_str_inverse.append(x_str.charAt(i));
        }
        System.out.println(x_str);
        System.out.println(x_str_inverse.toString());
        System.out.println(x_str.equals(x_str_inverse.toString()));
        return x_str.equals(x_str_inverse.toString());
    }

}
