import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            if (nums.length == 0) return ans;
            int i=0,j=i+1;
            for (; i < nums.length && j< nums.length; ) {
                if (nums[j]-nums[j-1]==1){
                    j++;
                }else {
                    if (j-i==1){
                        ans.add("" + nums[i]);
                    }else
                        ans.add(""+nums[i] + "->" + nums[j-1]);
                    i=j;
                    j=i+1;
                }
            }
            if (i == nums.length-1){
                ans.add(""+nums[i]);
            }else {
                ans.add("" + nums[i] + "->" + nums[j-1]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {

        SummaryRanges summaryRanges = new SummaryRanges();
        Solution solution = summaryRanges.new Solution();
        System.out.println(solution.summaryRanges(new int[]{0,1,2,4,5,7}));

    }

}
