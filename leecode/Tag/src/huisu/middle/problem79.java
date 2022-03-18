/** 单词搜索
 *  给定一个 m*n二维字符网格board 和 一个字符串单词。如果word存在于网格中，返回true；否则，返回false。
 *  单词必须按照字符顺序，通过相邻的单元格内的字母构成，其中”相邻“单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 */

package huisu.middle;

import java.util.HashMap;

public class problem79 {

    static int[] dx = new int[]{-1,0,1,0}, dy = new int[]{0,1,0,-1};


    public static void main(String[] args) {
        char[][] board = new char[][]{{'a', 'b'}, {'c','d'}};
        String word = "abcd";
        System.out.println(exist(board, word));

    }

    //自己写的只能通过部分用例
//    public static boolean exist(char[][] board, String word) {
//        StringBuilder sb = new StringBuilder();
//        HashMap<String, Character> res = new HashMap<>();
//        huisu(board, word, 0, sb, -1, -1, res);
//
//
//
//        return word.equals(sb.toString());
//    }
//
//    public static boolean huisu(char[][] board, String word, int inx, StringBuilder sb, int rows, int cols, HashMap<String, Character> res) {
//        if (inx == word.length()) return true;
//
//        int m = board.length;
//        int n = board[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j] != word.charAt(inx) || res.containsKey(""+i+j)) continue;
//                if (Math.abs(i-rows) + Math.abs(j-cols) > 1) continue;
//                sb.append(word.charAt(inx));
//                res.put(""+i+j, word.charAt(inx));
//                boolean f = huisu(board, word, inx+1, sb, i, j, res);
//                if (f) return f;
//                sb.deleteCharAt(sb.length() - 1 );
//                res.remove(""+i+j, word.charAt(inx));
//            }
//        }
//
//        return false;
//    }


    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                if(dfs(board,word,0,i,j)) return true;   //从每个节点出发进行判断，判断当前节点是否能搜索到给定字符串
        return false;
    }

    static boolean dfs(char[][] board, String word,int u,int x,int y)
    {
        if(board[x][y] != word.charAt(u)) return false; //当前字符不匹配，返回false；
        if(u == word.length() - 1)   return true; //当前字符能匹配，且已经匹配到最后一个字符，则返回true
        char t = board[x][y]; //取出当前匹配字符
        board[x][y] = '.';
        for(int i = 0; i < 4; i++)
        { //判断当前字符的上下左右四个方向是否有接下俩需要匹配的字符
            int a = x + dx[i], b = y + dy[i];
            if(a < 0 || a >= board.length|| b < 0 || b >= board[0].length || board[a][b] == '.')  continue; //前面四个都是为了防止下标越界；第五个是为了防止匹配到之前匹配过的字符
            if(dfs(board,word,u+1,a,b)) return true;
        }
        board[x][y] = t;
        return false;
    }


}


//另一种写法
//class Solution {
//    private boolean find;  // 定义为成员变量，方便以下两个成员方法使用和修改
//
//    public boolean exist(char[][] board, String word) {
//        if (board == null) return false;
//        int m = board.length, n = board[0].length;
//        boolean[][] visited = new boolean[m][n];
//        find = false;
//
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                backtracking(i, j, board, word, visited, 0);  // 从左上角开始遍历棋盘每个格子
//            }
//        }
//        return find;
//    }
//
//    /**
//     * i,j,board：棋盘格及当前元素的坐标
//     * word: 要搜索的目标单词
//     * visited：记录当前格子是否已被访问过
//     * pos: 记录目标单词的字符索引，只有棋盘格字符和pos指向的字符一致时，才有机会继续搜索接下来的字符；如果pos已经过了目标单词的尾部了，那么便说明找到目标单词了
//     */
//    public void backtracking(int i, int j, char[][] board, String word, boolean[][] visited, int pos){
//        // 超出边界、已经访问过、已找到目标单词、棋盘格中当前字符已经和目标字符不一致了
//        if(i<0 || i>= board.length || j<0 || j >= board[0].length || visited[i][j] || find
//                || board[i][j]!=word.charAt(pos))  return;
//
//        if(pos == word.length()-1){
//            find = true;
//            return;
//        }
//
//        visited[i][j] = true;  // 修改当前节点状态
//        backtracking(i+1, j, board, word, visited, pos+1);  // 遍历子节点
//        backtracking(i-1, j, board, word, visited, pos+1);
//        backtracking(i, j+1, board, word, visited, pos+1);
//        backtracking(i, j-1, board, word, visited, pos+1);
//        visited[i][j] = false; // 撤销修改
//    }
//
//}