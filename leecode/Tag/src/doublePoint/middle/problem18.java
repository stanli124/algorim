/** 四数之和
 *
 */

package doublePoint.middle;

import java.util.*;

public class problem18 {

    public static void main(String[] args) {
        fourSum(new int[]{2,2,2,2,2}, 8);
    }
//回溯写法始终会超时
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        LinkedList<Integer> track = new LinkedList<>();
//        HashSet<List<Integer>> result = new HashSet<>();
//
//        Arrays.sort(nums);
//        huisu(target,0, 0,0, nums, track, result);
//
//        for (List<Integer> one : result){
//            res.add(new ArrayList<>(one));
//        }
//
//        System.out.println(res);
//        return res;
//    }
//
//    public static void huisu(int target, int start, int len, int curSum, int[] nums, LinkedList<Integer> track, HashSet<List<Integer>> result){
//        if (len==4 && curSum==target){
//            result.add(new ArrayList<>(track));
//            return ;
//        }
//        if (len>4) return;
//
//        for (int i = start; i < nums.length; i++) {
////            if (i+1< nums.length && nums[i+1]==nums[i]) continue;
//            track.add(nums[i]);
//            huisu(target,i+1, len+1, curSum+nums[i], nums, track, result);
//            track.removeLast();
//        }
//
//    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }


}
