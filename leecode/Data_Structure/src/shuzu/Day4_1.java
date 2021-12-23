/**  重塑矩阵
 * 在 MATLAB 中，有一个非常有用的函数 reshape，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 *
 * 第一步判断是否是合法输入，也就是m*n是否等于c*r；
 *
 */


package shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4_1 {

    public static void main(String[] args) {

        int[][] mat = new int[][]{{1,2},{3,4}};

        long startTime = System.currentTimeMillis();
        System.out.println(matrixReshape(mat, 1, 4));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }


    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        //使用flattenMatrix来存储拉平的矩阵；然后将拉平的矩阵中的元素依次放入reshapeMatrix矩阵中；
//        int count = 0;
//        for (int[] mat_i : mat) {count+=mat_i.length;}
//        if (count!=r*c) return mat;
//
//        int[] flattenMatrix = new int[count];
//        int[][] reshapeMatrix = new int[r][c];
//        int idx = 0;
//
//        for (int[] arr : mat){
//            for (int num : arr) {
//                flattenMatrix[idx++] = num;
//            }
//        }
//
//        idx=0;
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                reshapeMatrix[i][j] = flattenMatrix[idx++];
//            }
//        }
//
//        return reshapeMatrix;












        // 不借助拉平的矩阵；直接将传入的mat矩阵依次填入reshapeMatrix矩阵中；
        int m = mat.length;
        int n = mat[0].length;
        int k = 0;
        int l = 0;

        if (m*n!=r*c) return mat;

        int[][] reshapeMatrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (l == n ) {
                    k=k+1;
                    l = 0;
                }
                reshapeMatrix[i][j] = mat[k][l];
                l++;
            }
        }
        return reshapeMatrix;




    }

}
