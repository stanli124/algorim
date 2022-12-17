package hot100.middle;

public class problem560 {

    int count = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        problem560 a = new problem560();
        System.out.println(a.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        huisu(nums, k, 0, 0, nums[0]);
        return count;
    }

    public void huisu(int[] nums, int k, int index, int preSum, int curSum) {
        if (index < nums.length)
            if (curSum == k) {
                count++;
                huisu(nums, k, index+1, preSum+nums[index], nums[index]);
            }else if (preSum == k){
//                count++;
                huisu(nums, k, index+1, preSum+nums[index], curSum+nums[index]);
            }else {
                huisu(nums, k, index+1, preSum+nums[index], curSum+nums[index]);
            }
        }
}
