package huisu.hard;

import java.util.*;

public class problem212 {

    //这种时间复杂度超了
//    public static void main(String[] args) {
//        char[][] board = new char[][]{{'a','b'},{'c','d'}};
//        String[] words = new String[]{"ab","ac","ad"};
//        findWords(board, words);
//    }
//
//    public static List<String> findWords(char[][] board, String[] words) {
//        LinkedList<String> res = new LinkedList<>();
//
//        for (int i = 0; i < words.length; i++) {
//            if (find(board, words[i])) res.add(words[i]);
//        }
//        System.out.println(res);
//        return res;
//    }
//
//    public static boolean find(char[][] board, String word) {
//        boolean[][] used = new boolean[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (huisu(board, word, 0, i, j, used)) return true;    //如果board中能找到当前单词，则返回true；以每个字母为起始点，
//            }
//        }
//        return false;
//    }
//
//    public static boolean huisu(char[][] board, String word, int inx, int rows, int cols, boolean[][] used){
//        if (rows < 0 || rows >= board.length || cols < 0 || cols >= board[0].length || used[rows][cols]) return false;
//        if (word.charAt(inx) != board[rows][cols]) return false;
//        if (inx == word.length()-1) return true;
//
//        used[rows][cols] = true;
//        boolean flag = huisu(board, word, inx+1, rows-1, cols, used) || huisu(board, word, inx+1, rows+1, cols, used) || huisu(board, word, inx+1, rows, cols-1, used) || huisu(board, word, inx+1, rows, cols+1, used);
//        if (flag) return true;
//        used[rows][cols] = false;
//        return false;
//    }

    static Set<String> set = new HashSet<>();
    static List<String> ans = new ArrayList<>();
    static char[][] board;
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int n, m;
    static boolean[][] vis = new boolean[15][15];

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b'},{'c','d'}};
        String[] words = new String[]{"abcd"};
        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] _board, String[] words) {
        board = _board;
        m = board.length; n = board[0].length;
        for (String w : words) set.add(w);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = true;
                sb.append(board[i][j]);
                dfs(i, j, sb);
                vis[i][j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return ans;
    }

    static void dfs(int i, int j, StringBuilder sb) {
        if (sb.length() > 10) return ;
        if (set.contains(sb.toString())) {
            ans.add(sb.toString());
            set.remove(sb.toString());
        }
        if (sb.length() == m*n) return;
        for (int[] d : dirs) {
            int dx = i + d[0], dy = j + d[1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
            if (vis[dx][dy]) continue;
            vis[dx][dy] = true;
            sb.append(board[dx][dy]);
            dfs(dx, dy, sb);
            vis[dx][dy] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
