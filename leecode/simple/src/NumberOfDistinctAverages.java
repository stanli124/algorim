import java.util.Arrays;
import java.util.HashSet;

public class NumberOfDistinctAverages {

    class Solution{
        public int distinctAverages(int[] nums) {
            Arrays.sort(nums);
            HashSet<Float> set = new HashSet<>();
//i < nums.length && j>=0
            for (int i = 0, j= nums.length-1; i < j; i++,j--) {
                float aver = (float) (nums[i] + nums[j]) / 2;
                set.add(aver);
            }
            return set.size();
        }
    }

    public static void main(String[] args) {
        NumberOfDistinctAverages numberOfDistinctAverages = new NumberOfDistinctAverages();
        Solution solution = numberOfDistinctAverages.new Solution();
        System.out.println(solution.distinctAverages(new int[]{1, 2, 3, 4}));
    }

}
