/** 组合总和3
 *  找出所有相加之和为n的 k个数的组合，且满足下列条件：
 *  只使用数字1-9
 *  每个数字最多使用一次
 *  返回所有可能的有效组合的列表。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *  输入k=3,n=7;  输出[[1,2,4]]
 */

//选择列表为[1-9]

package huisu.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem216 {

    public static void main(String[] args) {

        System.out.println(combinationSum3(9, 50));

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        huisu(1,0, k, n, track, res);

        return res;
    }

    public static void huisu(int start, int sum, int k, int n, LinkedList<Integer> track, List<List<Integer>> res){
        if (sum == n && track.size()==k){
            res.add(new ArrayList<>(track));
            return;
        }
        if (k >= n || sum > n) return;

        for (int i = start; i <= 9; i++) {
            track.add(i);
            huisu(i+1, sum+i, k, n, track, res);
            track.removeLast();
        }
    }

}
