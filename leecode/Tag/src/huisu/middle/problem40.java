/** 组合总和2
 *  给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *  candidates中的每个数字在每个组合中只能使用一次。
 *  答案中不能包含重复的组合
 */
//因为给定的数组中会有重复数字可以使用，但是每个数字只能使用一次；如，候选者中有两个数字1，但是这两个数字1每个都只能使用一次
package huisu.middle;

import java.util.*;

public class problem40 {

    //这个版本时间超时了
//    public static void main(String[] args) {
//        int[] candidates = new int[]{2,5,2,1,2}; //2,5,2,1,2 -> 5
//        int target = 5;
//
//        System.out.println(combinationSum2(candidates, target));
//
//    }
//
//    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        boolean[] used = new boolean[candidates.length];
//        List<List<Integer>> res = new ArrayList<>(); //最后返回的答案
//        List<Integer> track = new ArrayList<>(); //用来记录当前已经选择过的路径
//
//
//        HashMap<String,List<Integer>> ans = new HashMap();
//
//        dfs(used, track, ans, 0, target, candidates);
//
//        Set<String> a = ans.keySet();
//        for(String s : a){
//            res.add(ans.get(s));
//        }
//
//        return res;
//    }
//
//    public static void dfs(boolean[] used, List<Integer> track, HashMap<String,List<Integer>> ans, int sum, int target, int[] candidates){
//        if (sum == target){ //相等则将当前已经满足条件的加入最终集合
//            //去重
//            int[] nums = new int[track.size()];
//            StringBuilder s = new StringBuilder();
//            List<Integer> oneAns = new ArrayList<>();
//            for (int i = 0; i < track.size(); i++) {
//                nums[i] = track.get(i);
//            }
//            Arrays.sort(nums);
//
//            for (int i = 0; i < nums.length; i++) {
//                s.append(nums[i]);
//                oneAns.add(nums[i]);
//            }
//
//            if (!ans.containsKey(s)){
//                ans.put(s.toString(), oneAns);
//            }
//
//        }
//        if (sum > target) return;
//        for (int i = 0; i < candidates.length; i++) {
//            if (used[i]) continue;
//            used[i] = true;
//            track.add(candidates[i]);
//            sum += candidates[i];
//            dfs(used, track, ans, sum, target, candidates);
//            used[i] = false;
//            track.remove(track.size() - 1);
//            sum -= candidates[i];
//        }
//    }





    public static void main(String[] args) {
        int[] candidates = new int[]{1,1,1,1}; //2,5,2,1,2 -> 5
        int target = 4;

        System.out.println(combinationSum2(candidates, target));

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); //最后返回的答案
        LinkedList<Integer> track = new LinkedList<>(); //用来记录当前已经选择过的路径
        Arrays.sort(candidates);  //排序，让相同的值挨在一起

        dfs(track, res, 0, target, candidates, 0);

        return res;
    }

    public static void dfs(LinkedList<Integer> track, List<List<Integer>> res , int sum, int target, int[] candidates, int start){
        if (sum == target){ //相等则将当前已经满足条件的加入最终集合
            res.add(new ArrayList<>(track));
            return;
        }
        if (sum > target) return;

        for (int i = start; i < candidates.length; i++) { //start控制前面已经用过的变量就不使用了，也可以使用一个bool数组来替换
           //如果有多个相同的值，如candidates有三个2，控制如果已经有两个相同的值满足条件了，那么不能再使用第三个相同的值，这会造成相同的结果
            if (i > start && candidates[i] == candidates[i-1]) continue;

            sum += candidates[i];
            track.add(candidates[i]);
            dfs(track, res, sum, target, candidates, i+1);
            sum-=candidates[i];
            track.removeLast();

        }
    }
}
