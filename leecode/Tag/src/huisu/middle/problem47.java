/** 全排列
 *  给定一个可包含重复数字的序列nums，按任意顺序返回所有不重复的全排列
 */

package huisu.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class problem47 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3}; //[[1,1,2],[1,2,1],[2,1,1]]

        System.out.println(permuteUnique(nums));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);

//        huisu(nums, new boolean[nums.length], track, res);
        huisu(nums, 0, track, res);

        return res;
    }

//    public static void huisu(int[] nums, boolean[] used, LinkedList<Integer> track, List<List<Integer>> res){
//        if (track.size() == nums.length){
//            res.add(new ArrayList<>(track));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i]) continue;
//            if (i > 0 && nums[i] == nums[i-1] && used[i-1]) continue;
//
//            track.add(nums[i]);
//            used[i]=true;
//            huisu(nums, used, track, res);
//            track.removeLast();
//            used[i]=false;
//
//        }
//    }

    public static void huisu(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> res){
        if (track.size() == 4){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            huisu(nums, i+1, track, res);
            track.removeLast();

        }


    }

}
