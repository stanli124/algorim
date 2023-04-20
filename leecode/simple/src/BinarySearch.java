public class BinarySearch {

    class Solution {
        public int search(int[] nums, int target) {
            //返回有序数组中target的下标，若无则返回-1
            if (nums.length == 0) return -1;
            int lIndex = 0;
            int rIndex = nums.length-1;
            while (lIndex <= rIndex){
                int midIndex = (rIndex + lIndex) / 2;
                if (nums[midIndex] > target) rIndex = midIndex-1;
                else if (nums[midIndex] < target) lIndex = midIndex + 1;
                else return midIndex;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        Solution solution = binarySearch.new Solution();
        System.out.println(solution.search(new int[]{1, 2, 3, 4, 5}, 5));
    }

}
