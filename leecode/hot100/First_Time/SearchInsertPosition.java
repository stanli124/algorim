public class SearchInsertPosition {
    public static void main(String[] args) {
        SSolution sSolution = new SSolution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(sSolution.searchInsert(nums, 3));
    }
}


class SSolution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}