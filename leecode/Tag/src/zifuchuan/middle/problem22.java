/** 括号生成
 *  数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合
 *  1.每个左括号或者右括号都必须有与之对应匹配的括号
 *  2.右括号不能在左括号前面
 */

package zifuchuan.middle;

import java.util.LinkedList;
import java.util.List;

public class problem22 {

    public static void main(String[] args) {

        generateParenthesis(3);

    }

    public static List<String> generateParenthesis(int n) {
        StringBuffer track = new StringBuffer();
        List<String> result = new LinkedList();

        trackback(result, new StringBuffer(), 0, 0, n);
        return result;
    }

    public static void trackback(List<String> res, StringBuffer track, int left_nums, int right_nums, int n){
        if (track.length()==n*2){
            System.out.println(track);
            res.add(track.toString());
            return;
        }

        if (left_nums < n){
            track.append('(');
            trackback(res, track, left_nums+1, right_nums, n);
            track.deleteCharAt(track.length() - 1);
        }
        if (right_nums < left_nums){
            track.append(')');
            trackback(res, track, left_nums, right_nums+1, n);
            track.deleteCharAt(track.length() - 1);
        }

    }



}
