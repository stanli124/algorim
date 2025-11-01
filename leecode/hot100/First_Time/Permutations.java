import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        PSolution pSolution = new PSolution();
        System.out.println(pSolution.permute(new int[]{1,2,3}));
    }
}


class PSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        all(nums, ans, new ArrayList<>());
        return ans;
    }

    private void all(int[] nums, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            all(nums, res, path);
//            path.remove(path.size() - 1);
        }
    }
}