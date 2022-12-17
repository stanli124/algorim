package JianZhiOffer;

import java.util.HashMap;

//和为s的两个数字
//一个递增数组、一个数字s
public class Q57 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])){
                return new int[]{nums[i], m.get(nums[i])};
            }
            m.put(target - nums[i], nums[i]);
        }



        return new int[]{-1,-1};
    }

}
