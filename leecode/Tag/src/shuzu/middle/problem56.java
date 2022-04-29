/** 合并区间
 *  数组intervals表示若干个区间的集合，其中单个区间为intervals[i] = [start_i, end_i]
 *  请你合并所有  重叠  的区间，  返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */

package shuzu.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class problem56 {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        int[][] res = merge(intervals);



    }

//没有通过所有的案例
//    public static int[][] merge(int[][] intervals) {
//
//        ArrayList<int[]> save = new ArrayList<>();
//
//
//        int start = 0;
//        int pre = start;
//        int end = pre+1;
//        int minNum = Integer.MIN_VALUE;
//        int maxNum = Integer.MAX_VALUE;
//
//        while (end < intervals.length){
//            if (intervals[pre][1] >= intervals[end][0]){
//
//
//
//                //start 和 end这两个区间有重叠
//                pre = end;
//                end++;
//            }else {
//                save.add(new int[]{intervals[start][0], intervals[end-1][1]});
//                start = end;
//                pre = start;
//                end = start + 1;
//            }
//        }
//        if (end == intervals.length && end > start){
//            save.add(new int[]{intervals[start][0], intervals[end-1][1]});
//        }
//
//        int[][] res = new int[save.size()][2];
//        for (int i = 0; i < save.size(); i++) {
//            res[i] = save.get(i);
//        }
//
//        return res;
//    }

    public static int[][] merge(int[][] intervals){
        if (intervals.length == 0){
            return new int[0][2];
        }

        //对所有区间的左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                //如果merge中 最后一个数组的第1个元素 小于 当前数组的L； 则说明不是重叠区间；直接添加；
                merged.add(new int[]{L, R});
            }else {
                //如果>=当前数组的最小值，则是重叠区间。然后更新当前最后一个数组的R值，
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }

        }

        return merged.toArray(new int[merged.size()][]);

    }



}
