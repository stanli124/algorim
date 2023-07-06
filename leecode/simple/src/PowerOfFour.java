public class PowerOfFour {

    class Solution{
        public boolean isPowerOfFour(int n){
            int num = 1;
            while (num <= n){
                if (num == n) return true;
                if (num > 1073741823) return false;
                num = num << 2;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();
        Solution solution = powerOfFour.new Solution();
        System.out.println(solution.isPowerOfFour(2147483647));
    }

}
