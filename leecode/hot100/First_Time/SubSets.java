import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        SSolution2 sSolution = new SSolution2();
        System.out.println(sSolution.subsets(new int[]{1, 2}));
    }
}

class SSolution2 {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}