public class Problem53 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    public static int search(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) {
            return 0;
        }
        int high = index;
        int low = index;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                high = i;
            } else {
                break;
            }
        }
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] == target) {
                low = i;
            } else {
                break;
            }
        }

        return high - low + 1;
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
