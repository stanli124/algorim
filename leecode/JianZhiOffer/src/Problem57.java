import java.util.HashMap;
import java.util.HashSet;

public class Problem57 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), nums[i]};
                } else {
                    map.put(target - nums[i], nums[i]);
                }
            }
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        Problem57 problem57 = new Problem57();
        Solution solution = problem57.new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
