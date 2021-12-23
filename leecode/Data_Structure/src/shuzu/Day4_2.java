/** 杨辉三角
 * 给定一个非负整数numRows， 生成杨辉三角的前numRows行；
 * 在杨辉三角中，每个数是它左上方和右上方的数的和；
 *
 */

package shuzu;

import java.util.ArrayList;
import java.util.List;

public class Day4_2 {

    public static void main(String[] args) {

        int numRows = 5;

        long startTime = System.currentTimeMillis();
        System.out.println(generate(numRows));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> yangHui = new ArrayList<>();
        int idx = 0;

        List<Integer> rows = new ArrayList<>();
        rows.add(1);
        yangHui.add(rows);     //单独添加第一行；

        for (int i = 1; i < numRows; i++) {
            rows = new ArrayList<>();   //用来保存当前层的所有值；
            rows.add(1);
            idx = 0;
            for (int j = 1; j <= i-1; j++) {    //该for循环使用上一层来计算当前层的值；j用来控制当前层需要进行几次计算；如第四层只有中间两个数字需要计算，因为首尾都是1；
                rows.add(yangHui.get(i-1).get(idx)+yangHui.get(i-1).get(idx+1));
                idx++;
            }
            rows.add(1);
            yangHui.add(rows);
        }

        return yangHui;

    }

}
