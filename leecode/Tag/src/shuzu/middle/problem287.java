package shuzu.middle;

import java.util.HashMap;
import java.util.HashSet;

public class problem287 {

    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!res.add(nums[i])) return nums[i];
        }
        return 0;
    }

}
