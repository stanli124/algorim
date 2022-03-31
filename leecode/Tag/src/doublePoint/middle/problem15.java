package doublePoint.middle;

import java.util.*;

public class problem15 {

    public static void main(String[] args) {
        threeSum(new int[]{11,-8,9,-6,-10,14,-5,-10,2,-1,-14,-13,-5,9,-5,-12,9,5,-1,-4,-14,5,-11,3,6,-7,2,-14,9,-6,-8,-2,-7,8,7,-2,7,9,3,-14,-14,5,-12,-4,-9,-1,-8,7,11,-2,-11,4,-11,-15,-7,10,-7,10,4,10,11,11,-7,-11,4,7,2,-12,1,12,-10,2,2,-15,6,1,-1,13,-7,-12,-4,-11,7,0,-11,-15,-12,-10,2,7,-15,-2,3,-15,-6,14,-1,11,-13,-15,9,14,-5,-12,-15,-14,4,-9,6,5,-6,-13,9});
    }
//回溯做法会超时
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        LinkedList<Integer> track = new LinkedList<>();
//        HashSet<List<Integer>> result = new HashSet<>();
//
//        Arrays.sort(nums);
//        huisu(0, 0,0, nums, track, result);
//
//        for (List<Integer> one : result){
//            res.add(new ArrayList<>(one));
//        }
//
//        System.out.println(res);
//        return res;
//    }
//
//    public static void huisu(int start, int len, int curSum, int[] nums, LinkedList<Integer> track, HashSet<List<Integer>> result){
//        if (len==3 && curSum==0){
//            result.add(new ArrayList<>(track));
//            return ;
//        }
//        if (len>3) return;
//
//        for (int i = start; i < nums.length; i++) {
////            if (i+1< nums.length && nums[i+1]==nums[i]) continue;
//            track.add(nums[i]);
//            huisu(i+1, len+1, curSum+nums[i], nums, track, result);
//            track.removeLast();
//        }
//
//    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length - 1;
            if (i>0 && nums[i]==nums[i-1]) continue;
            while (left < right){
                if (nums[i] + nums[left] + nums[right] == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) right--; //如果右边有相等的元素则跳过，防止重复添加
                    while (right > left && nums[left] == nums[left + 1]) left++;  //如果左边有相等的元素则跳过，防止重复添加
                    left++;
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }
            }
        }

        System.out.println(res);
        return res;
    }

    public static boolean help(int a, int b, int c){
        if (a+b+c==0) return true;
        return false;
    }

}
