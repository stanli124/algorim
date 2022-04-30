package shuzu.simple;

import java.util.ArrayList;
import java.util.List;

public class problem448 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        boolean[] isExist = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            isExist[nums[i]] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!isExist[i]){
                res.add(i);
            }
        }


//        for (int i = 1; i <= n; i++) {
//            res.add(i);
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (res.contains((Object) nums[i])) res.remove((Object) nums[i]);
//        }




        return res;
    }

}
