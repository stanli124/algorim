/** 组合总和
 *  给定一个无重复元素的整数数组 candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合，并以列表形式返回。你可以按任意顺序返回这些组合。
 */

package shuzu.middle;

import java.util.*;

public class problem39 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5},8));
    }
//
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        int len = candidates.length;
//        List<List<Integer>> allCombine = new ArrayList<>();
//        Map<Integer, Integer> valueToIndex = new LinkedHashMap<>();
//        Arrays.sort(candidates);
////        if (len==1 && candidates[0]==target){
////            allCombine.add(Arrays.asList(candidates[0]));
////            return allCombine;
////        }
//
//        for (int i = 0; i < len; i++) {
//            int subValue = target;
//            valueToIndex.clear();
//            if (target == candidates[i]){   //处理等于target的情况
//                allCombine.add(Arrays.asList(candidates[i]));
//                continue;
//            }
//            else if (target % candidates[i] == 0) {  //能整除target，并添加target-candidates[i]到map中，因为后面可能有值加上该值等于target;
//                ArrayList<Integer> oneCombine = new ArrayList<>();
//                for (int k = 0; k < target / candidates[i]; k++) {
//                    oneCombine.add(candidates[i]);
//                }
//                allCombine.add(oneCombine);
//                subValue = subValue - candidates[i];
//                valueToIndex.put(subValue, i);
//            }
//            else {  //不能整除的时候，直接添加差值
//                subValue = subValue - candidates[i];
//                valueToIndex.put(subValue, i);
//            }
//
//            //不等于target的情况
//            for (int j = i + 1; j < len; j++) {
//                if (subValue % candidates[j] == 0){
//                    ArrayList<Integer> oneCombine = new ArrayList<>();
//                    if (candidates[j]==subValue && valueToIndex.size() > 0){
//                        Iterator it = valueToIndex.keySet().iterator();
//                        while (it.hasNext()) {
//                            oneCombine.add(candidates[valueToIndex.get(it.next())]);
//                        }
//                    }else{
//                        Iterator it = valueToIndex.keySet().iterator();
//                        while (it.hasNext()) {
//                            oneCombine.add(candidates[valueToIndex.get(it.next())]);
//                        }
//                        for (int k = 0; k < subValue / candidates[j]; k++) {
//                            oneCombine.add(candidates[j]);
//                        }
//                    }
//                    allCombine.add(oneCombine);
//                }
//
//
//                if (!valueToIndex.containsKey(candidates[j])) {  //不包含当前
//                    subValue = subValue - candidates[j];
//                    valueToIndex.put(subValue, j);
//                } else {
//                    ArrayList<Integer> oneCombine = new ArrayList<>();
//                    Iterator it = valueToIndex.keySet().iterator();
//                    while (it.hasNext()) {
//                        oneCombine.add(candidates[valueToIndex.get(it.next())]);
//                    }
//                    oneCombine.add(candidates[j]);
//                    allCombine.add(oneCombine);
//                    valueToIndex.clear();
//                    subValue = target;
//                    break;
//                }
//            }
//
//        }
//        return allCombine;
//
//    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }


    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }



}
