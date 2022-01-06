/** 旋转图像
 *  给定一个n * n的二维矩阵matrix表示一个图像，请你将图像顺时针旋转90度。
 *  你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像
 */

package shuzu.middle;

import java.util.Arrays;

public class problem48 {

    public static void main(String[] args) {


        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});


    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] cp = new int[n][n];

        for (int i = 0; i < n; i++) {   //复制数组
            for (int j = 0; j < n; j++) {
                cp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {  //转置
            for (int j = 0; j < n; j++) {
                matrix[j][i] = cp[i][j];
            }
        }

        int i=0;
        int j=n-1;
        while (i < j){
            int[] saveCol = new int[n];
            for (int k = 0; k < n; k++) {
                saveCol[k] = matrix[k][i];
            }

            for (int k = 0; k < n; k++) {
                matrix[k][i] = matrix[k][j];
            }

            for (int k = 0; k < n; k++) {
                matrix[k][j] = saveCol[k];
            }
            i++;
            j--;
        }



        for (int k = 0; k < n; k++) {
            for (int m = 0; m < n; m++) {
                System.out.print(matrix[k][m]);
            }
            System.out.println();
        }

    }

}
