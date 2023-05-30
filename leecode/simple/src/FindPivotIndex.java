public class FindPivotIndex {

    class Solution{
        public int pivotIndex(int[] nums){
            int length = nums.length;
            int[] prefixSum = new int[length];
            prefixSum[0] = nums[0];

            for (int i = 1; i < length; i++) {
                prefixSum[i] = prefixSum[i-1] + nums[i];
            }

            for (int i = 0; i < length; i++) {
                int leftSum = 0;
                int rightSum = 0;
                if (i==0){
                    rightSum = prefixSum[length-1] - nums[i];
                }else if(i==length-1){
                    leftSum = prefixSum[i-1];
                }else {
                    leftSum = prefixSum[i-1];
                    rightSum = prefixSum[length-1] - prefixSum[i];
                }
                if (leftSum == rightSum) return i;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        Solution solution = findPivotIndex.new Solution();
        System.out.println(solution.pivotIndex(new int[]{2,1,-1}));
    }

}
