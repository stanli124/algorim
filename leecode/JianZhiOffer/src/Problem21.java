public class Problem21 {

    class Solution {
        public int[] exchange(int[] nums) {
            int low = 0;
            int high = nums.length - 1;

            while (low < high){
                while (low < high && nums[low] % 2 != 0) low++; // 从前找偶数
                while (low < high && nums[high] % 2 !=1) high--; // 从后找奇数
                int swap = nums[low];
                nums[low] = nums[high];
                nums[high] = swap;
                ++low;
                --high;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Problem21 problem21 = new Problem21();
        Solution solution = problem21.new Solution();
        System.out.println(solution.exchange(new int[]{1, 2, 3, 4}));
    }

}
