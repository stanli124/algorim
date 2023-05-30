public class SortArrayByParity {

    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            while (left < right){
                while (left < nums.length && nums[left] % 2 == 0) left++;  //找到第一个奇数
                while (right >= 0 && nums[right] % 2 !=0) right--; //找到第一个偶数
                if (left == nums.length || right < 0 || left >= right) break;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        Solution solution = sortArrayByParity.new Solution();
        int[] sorted = solution.sortArrayByParity(new int[]{
                0,1
        });
        for (int num : sorted){
            System.out.printf("%d ",num);
        }
    }

}
