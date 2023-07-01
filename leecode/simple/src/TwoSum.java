import java.util.HashMap;

public class TwoSum {

    class Solution{

        public int[] twoSum(int[] nums, int target){
            if (nums.length < 2) return new int[]{};
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])){
                    return new int[]{map.get(nums[i]), i};
                }else
                    map.put(target - nums[i],i);
            }
            return new int[]{};
        }

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        Solution solution = twoSum.new Solution();
        int[] indexs = solution.twoSum(new int[]{3, 3}, 6);
        for (int n :
                indexs) {
            System.out.printf("%d ", n);
        }
    }

}
