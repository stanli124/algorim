import java.util.Arrays;

public class MaxProductOfThreeNums {

    class Solution{
        public int maximumProduct(int[] nums){
//            int length = nums.length;
//            if (length == 3) return nums[0] * nums[1] * nums[2];
//            Arrays.sort(nums);
//
//            if (nums[0] < 0 && nums[1] < 0){
//                if (-nums[0] > nums[length-1] && -nums[1] > nums[length-2]){ //左边第一个大于右边第一个，左边第二个大于右边第二个
//                    return nums[0] * nums[1] * nums[length-1];
//                }else if (-nums[0] < nums[length-1] && -nums[0] > nums[length-2] && -nums[1] > nums[length-2]){
//                    //左边第一个小于右边第一个，但是左边1，2个都大于右边第二个
//                    return nums[0] * nums[1] * nums[length-1];
//                } else if (-nums[0] < nums[length-2] && -nums[1] < nums[length-2]) {
//                    if (nums[0] * nums[1] * nums[length-1] > nums[length-1] * nums[length-2] * nums[length-3])
//                        return nums[0] * nums[1] * nums[length-1];
//                    else {
//                        return nums[length-1] * nums[length-2] * nums[length-3];
//                    }
//                } else {
//                    return nums[length-1] * nums[length-2] * nums[length-3];
//                }
//            }else
//                return nums[length-1] * nums[length-2] * nums[length-3];
            Arrays.sort(nums);
            int n = nums.length;
            return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
        }
    }


    public static void main(String[] args) {
        MaxProductOfThreeNums maxProductOfThreeNums = new MaxProductOfThreeNums();
        Solution solution = maxProductOfThreeNums.new Solution();
        System.out.println(solution.maximumProduct(new int[]{1,0,101}));
    }

}
