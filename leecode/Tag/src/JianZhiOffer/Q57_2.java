package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Q57_2 {

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

    public static int[][] findContinuousSequence(int target) {
        int n = target/2 + 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            ArrayList<Integer> ans = new ArrayList<>();
            for (int j = i; j <= n; j++) {
                sum += j;
                ans.add(j);
                if (sum == target){
                    res.add(new ArrayList<>(ans));
                    break;
                }else if (sum > target){
                    break;
                }
            }
        }

        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int len = res.get(i).size();
            int[] oneAns = new int[len];
            for (int j = 0; j < len; j++) {
                oneAns[j] = res.get(i).get(j);
            }
            ans[i] = oneAns;
        }

        return ans;
    }

}
