package huisu.middle;

import java.util.*;

public class problem {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> aAns = new LinkedList<>();

        huisu(0, ans, aAns, nums);

        Iterator<List<Integer>> iter = ans.iterator();
        for (Iterator<List<Integer>> it = iter; it.hasNext(); ) {
            List<Integer> a = it.next();
            res.add(a);
        }

        return res;
    }

    public static void huisu(int start, HashSet<List<Integer>> ans,LinkedList<Integer> aAns, int[] nums){
        ans.add(new ArrayList<>(aAns));
        if (start > nums.length) return;

        for (int i = start; i < nums.length; i++) {
            aAns.add(nums[i]);
            huisu(i+1, ans, aAns, nums);
            aAns.removeLast();
        }

    }

}
