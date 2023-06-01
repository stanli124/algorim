public class SquaresOfSortedArray {

    class Solution{
        public int[] sortedSquares(int[] nums){
            //第一个循环先找到负数和正数的分界点
            int pivot = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >=0) {
                    pivot = i;
                    break;
                }
            }

            int[] sorted = new int[nums.length];
            //全是正数
            if (nums[0] >= 0){
                for (int i = 0; i < nums.length; i++) {
                    sorted[i] = nums[i]*nums[i];
                }
                return sorted;
            }
            //全是负数
            if (pivot == -1){
                int j = 0;
                for (int i = nums.length-1; i >= 0; i--) {
                    sorted[j++] = nums[i]*nums[i];
                }
                return sorted;
            }

            //双指针，通过比较正数和负数的绝对值的大小，将小的放入一个新的数组中
            int negative = pivot - 1;
            int positive = pivot;
            int index = 0;
            while (negative >= 0 && positive < nums.length){
                int abs = Math.abs(nums[negative]);
                if (nums[positive] > abs){
                    sorted[index++] = abs * abs;
                    negative--;
                }else {
                    sorted[index++] = nums[positive] * nums[positive];
                    positive++;
                }
            }
            while (negative >= 0){
                int abs = Math.abs(nums[negative]);
                sorted[index++] = abs * abs;
                negative--;
            }
            while (positive < nums.length){
                sorted[index++] = nums[positive] * nums[positive];
                positive++;
            }

            return sorted;
        }
    }

    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        Solution solution = squaresOfSortedArray.new Solution();
        int[] squares = solution.sortedSquares(new int[]{-2,0});
        for (int n : squares){
            System.out.printf("%d ", n);
        }
    }

}


