import java.util.Arrays;

public class ThirdMaxNum {

    public static void main(String[] args) {

        class Solution{
            public int thirdMax(int[] nums) {
                Arrays.sort(nums);
                if (nums.length < 3) return nums[nums.length-1];

                int diff = 1;
                for (int i = nums.length-2; i>=0 ; i--) {
                    if (nums[i] != nums[i+1]){
                        diff++;
                    }
                    if (diff==3) return nums[i];
                }

                return nums[nums.length-1];
            }
        }

        Solution solution = new Solution();
        System.out.println(solution.thirdMax(new int[]{2,3}));

    }

}
