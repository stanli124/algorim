public class PowerOfTwo {

    class Solution{

        public boolean isPowerTwo(int n){
            int num = 1;
            for (int i = 1; i < 32; i++) {
                if (num == n) return true;
                num = num * 2;
            }
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(1073741825 * 2 * 2); 这个测试用例会超出int表示范围
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        Solution solution = powerOfTwo.new Solution();
        System.out.println(solution.isPowerTwo(1073741824));//2,147,483,647
    }

}
