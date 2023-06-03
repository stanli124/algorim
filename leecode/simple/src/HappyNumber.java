import java.util.HashSet;

public class HappyNumber {

    class Solution{
        public boolean isHappy(int n) {
            HashSet<Integer> circle = new HashSet<>();
            int sum = 0;
            while (sum != 1 || n != 0){
                if (n == 0){
                    if (!circle.add(sum)) return false;
                    n = sum;
                    sum = 0;
                }
                int digit = n % 10;
                sum += digit * digit;
                n = (n - digit) / 10;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        Solution solution = happyNumber.new Solution();
        System.out.println(solution.isHappy(11));
    }

}
