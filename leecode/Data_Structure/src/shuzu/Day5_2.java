/**  矩阵置0
 *   给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法
 *
 *   记录矩阵中所有0元素的位置，并对这些位置的索引置0
 */



package shuzu;

public class Day5_2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        long startTime = System.currentTimeMillis();
        setZeroes(matrix);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }

    public static void setZeroes(int[][] matrix) {
        //遍历数组记录需要置0的行和列，需要额外的两个数组来保存需要置0的行列索引；
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int[] rows = new int[m];   //记录需要置0的行
//        int[] cols = new int[n];   //记录需要置0的列
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0){
//                    rows[i] = 1;
//                    cols[j] = 1;
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++) {   //整行置0
//            if (rows[i]==1) matrix[i] = new int[n];
//        }
//        for (int i = 0; i < n; i++) {   //整列置0
//            if (cols[i]==1) {
//                for (int j = 0; j < m; j++) {
//                    matrix[j][i] = 0;
//                }
//            }
//        }
//
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean colSet0 = false;
        boolean rowSet0 = false;

        for (int k : matrix[0]){  //记录第0行是否要置0；
            if (k==0){
                rowSet0 = true;
                break;
            }
        }
        for (int i = 0; i < m; i++){  //记录第0列是否需要置0；
            if (matrix[i][0]==0) {
                colSet0 = true;
                break;
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;  //记录列的位置
                    matrix[i][0] = 0;  //记录行的位置
                }
            }
        }

        for (int i = 1; i < m; i++) {  //行置0；
            if (matrix[i][0]==0) matrix[i] = new int[n];
        }

        for (int i = 1; i < n; i++) { //列置0；
            if (matrix[0][i]==0){
                for (int j = 1; j < m; j++) {
                    matrix[j][i]=0;
                }
            }
        }

        if (rowSet0) matrix[0] = new int[n];
        if (colSet0){
            for (int i = 0; i < m; i++) matrix[i][0]=0;

        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }




    }

}
