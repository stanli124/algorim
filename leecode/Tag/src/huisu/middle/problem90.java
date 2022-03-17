/** 子集
 *  给你一个整数数组nums，其中可能包含重复元素，请你返回该数组所有可能的子集
 *  解集不能包含重复的子集
 */

package huisu.middle;

import java.util.*;

public class problem90 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{4,4,4,1,4}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        huisu(res, track, 0, nums);

//        HashSet<List<Integer>> ans = new HashSet<>();
//        for (int i = 0; i < res.size(); i++) {
//            if (ans.add(res.get(i))){
//                result.add(res.get(i));
//            }
//        }

        return res;
    }

    public static void huisu(List<List<Integer>> res, LinkedList<Integer> track, int start, int[] nums){
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            track.add(nums[i]);
            huisu(res, track, i+1, nums);
            track.removeLast();
        }
    }

}
