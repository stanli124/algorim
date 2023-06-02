public class RunningSumof1DArray {

    public static void main(String[] args) {

        class Solution{
            public int[] runningSum(int[] nums) {
                for (int i = 1; i < nums.length; i++) {
                    nums[i] = nums[i]+nums[i-1];
                }
                return nums;
            }
        }

        Solution solution = new Solution();
        int[] runningSum = solution.runningSum(new int[]{1});
        for (int num : runningSum){
            System.out.printf("%d ", num);
        }

    }

}
