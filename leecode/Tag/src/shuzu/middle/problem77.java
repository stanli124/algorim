/** 组合
 *  给定两个整数n和k，返回范围[1,n]中所有可能的k个数的组合。
 *  可以按照任何顺序返回答案。
 */

package shuzu.middle;

import java.util.LinkedList;
import java.util.List;

public class problem77 {

    public static void main(String[] args) {

        int n = 4;
        int k = 3;

        System.out.println(combine(n, k));

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new LinkedList<>(); //记录路径，路径上是已经选择了的值;
        List<List<Integer>> result = new LinkedList<>();

        backtrack(n, track, result, k, 0);
        return result;
    }

    //n是区间[1,n]，k是每个组合包含的不重复元素，track记录每一次的选择，result保存满足条件的数组，offset是偏移量，防止本来已经有[1,2]这种组合后还有[2,1]这种组合；
    public static void backtrack(int n, List<Integer> track, List<List<Integer>> result, int k, int offset){
        if (track.size() == k){
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 1+offset; i <= n; i++) {
//            if (track.contains(i)) continue; //去除掉不合法，也就是相同的值；
            track.add(i);
            backtrack(n, track, result, k, i);
            track.remove(track.size()-1);
        }

    }


}
