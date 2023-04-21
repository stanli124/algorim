public class AddDigits {

    class Solution {
        public int addDigits(int num) {
            int sumDigits = 100;
            while (sumDigits >= 10){
                sumDigits = 0;
                while (num != 0){
                    int digits = num % 10;
                    sumDigits += digits;
                    num = num / 10;
                }
                num = sumDigits;
            }
            return sumDigits;
        }
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        Solution solution = addDigits.new Solution();
        System.out.println(solution.addDigits(88));
    }

}
