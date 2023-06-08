public class PowerOfTwo {

    class Solution{

        public boolean isPowerTwo(int n){
            int num = 1;
            for (int i = 1; i < 32; i++) {
                if (num == n) return true; //如果将条件i<32设置为i<31，那么在i==30<31的时候会判断为true进入循环num变为1073741824，但这个时候i加1为31，那么下一次就不会进入循环，也就不会返回true
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
