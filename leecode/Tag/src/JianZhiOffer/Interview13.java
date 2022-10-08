package JianZhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Interview13 {

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
    }

//    public static int movingCount(int m, int n, int k){
//        int answer = 0;
//        int[][] rows;
//        int[][] cols;
//
//        if ( m>9) {
//            rows = new int[m-10][2];
//            int rowIndex0 = 1;
//            int rowIndex1 = 0;
//            for (int i = 0; i < m-10; i++) {
//                if (rowIndex1 == 10) rowIndex0++;
//                rowIndex1 = rowIndex1 % 10;
//                rows[i][0] = rowIndex0;
//                rows[i][1] = rowIndex1++;
//            }
//        }else rows = new int[10][2];
//        if ( n>9) {
//            cols = new int[n-10][2];
//            int colIndex0 = 1;
//            int colIndex1 = 0;
//            for (int i = 0; i < n-10; i++) {
//                if (colIndex1 == 10) colIndex0++;
//                colIndex1 = colIndex1 % 10;
//                cols[i][0] = colIndex0;
//                cols[i][1] = colIndex1++;
//            }
//        }else cols = new int[10][2];
//
//
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int digitSum = 0;
//                if (i > k || j > k) return answer;
//                if (i > 9){
//                    digitSum += rows[i-10][0] + rows[i-10][1];
//                }else {
//                    digitSum += i;
//                }
//                if (j > 9){
//                    digitSum += cols[j-10][0] + cols[j-10][1];
//                }else
//                    digitSum += j;
//
//                if (digitSum <= k) answer++;
//
//            }
//        }
//
//        return answer;
//    }

    public static int movingCount(int m, int n, int k){
        if (k == 0) return 1;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0,1};
        int[] dy = {1,0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0,0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || digitSum(tx)+digitSum(ty) > k){
                    continue;
                }
                queue.offer(new int[]{tx,ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    public static int digitSum(int num){
        int res = 0;
        while (num!=0){
            res += num % 10;
            num /= 10;
        }
        return res;
    }


}
