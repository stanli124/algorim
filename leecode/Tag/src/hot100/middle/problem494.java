package hot100.middle;

import java.util.HashSet;

public class problem494 {
    int count = 0;
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 0;
        problem494 a = new problem494();
        System.out.println(a.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        boolean[] visited = new boolean[nums.length];
        huisu(nums, target, 0, 0);
        return count;
    }

    public void huisu(int[] nums, int target, int index, int curSum){
        if (index == nums.length) {
            if (curSum == target) {
                count++;
            }
        } else {
            huisu(nums, target, index + 1, curSum + nums[index]);
            huisu(nums, target, index + 1, curSum - nums[index]);
        }

    }

//    public void huisu(int[] nums, int target, boolean[] vis, int curSum, HashSet<String> str, StringBuilder sb, int index){
//        if (index == nums.length){
//            if (curSum == target){
//                count++;
//                str.add(sb.toString());
//            }
//        }
//        for (int i = index; i < nums.length; i++) {
//            if (vis[i]) continue;
//            vis[i] = true;
//            huisu(nums, target, vis, curSum+nums[i], str, sb.append("+"+nums[i]), index+1);
//            huisu(nums, target, vis, curSum-nums[i], str, sb.append("-"+nums[i]), index+1);
//            vis[i] = false;
//        }
//    }

}
