/** N皇后
 *  将n个皇后放在n*n的棋盘上，使皇后之间不能相互攻击。
 *  给你一个整数n，返回所有不同的
 */
//从第一行开始，每一行放一个皇后

package huisu.hard;

import java.util.ArrayList;
import java.util.List;

public class problem {

    public static void main(String[] args) {
        System.out.println(solveNQueens(5));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<StringBuffer> aAns = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }

        for (int i = 0; i < n; i++) {
            aAns.add(new StringBuffer(sb.toString()));
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(aAns.get(i));
//        }

        backtrack(0, aAns, res);

        return res;
    }

    public static void backtrack(int rows, List<StringBuffer> aAns, List<List<String>> res){
        int n = aAns.size();
        if (rows == n){ //如果已经填充完指定行数，则添加答案
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(aAns.get(i).toString());
            }
            res.add(ans);
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(rows, i, aAns)){ //选择在第几行插入Q，选择列表是n个列；如果当前行的某列满足条件；那么在下面的语句中会将改行该列替换为Q；
                continue;
            }
            aAns.get(rows).replace(i, i+1, "Q");
            backtrack(rows+1, aAns, res);
            aAns.get(rows).replace(i, i+1, ".");
        }
    }

    public static boolean isValid(int rows, int cols, List<StringBuffer> aAns){
        int n = aAns.size();
        //判断当前列是否已经存放皇后
        for (int i = 0; i < rows; i++) {
            if (aAns.get(i).charAt(cols) == 'Q') return false;
        }

        //判断左上是否已经存放皇后
        for (int i = rows-1, j = cols-1; i >= 0 && j >= 0; i--,j--) {
            if (aAns.get(i).charAt(j) == 'Q') return false;
        }

        //判断右上是否已经存放皇后
        for (int i = rows-1, j = cols+1; i >= 0 && j < n; i--,j++) {
            if (aAns.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }


}
