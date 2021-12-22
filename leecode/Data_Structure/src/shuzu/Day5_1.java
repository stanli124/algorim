/** 有效的数独
 *  数字 1-9 在每一行只能出现一次。
 *  数字 1-9 在每一列只能出现一次。
 *  数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 */

package shuzu;

import java.util.HashSet;

public class Day5_1 {

    public static void main(String[] args) {

        char[][] board = new char[][]{
                  {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));

    }


    public static boolean isValidSudoku ( char[][] board){

//        for (char[] s : board)
//        {
//            for (int i = 0; i < s.length; i++) {
//                if (i%3==0) System.out.print("   ");
//                System.out.print(s[i]+" ");
//            }
//            System.out.println();
//        }

        HashSet<String> row = new HashSet<>();
        HashSet<String> col = new HashSet<>();

        for (int i = 0; i < 9; i++) { //整行、整列都不包含重复值
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.'){
                    if (row.add(String.valueOf(board[i][j]))){}
                    else return false;
                }
                if (board[j][i]!='.'){
                    if (col.add(String.valueOf(board[j][i]))){}
                    else return false;
                }
            }
            row.clear();
            col.clear();
        }

        //一个小的九宫格中不包含重复数字

        for (int i = 0; i < 9; i++) {
            if (i%3==0) row.clear();
            for (int j = 0; j < 3; j++) {
                if (board[i][j]!='.'){
                    if (row.add(String.valueOf(board[i][j]))){}
                    else return false;
                }
            }
        }
        row.clear();

        for (int i = 0; i < 9; i++) {
            if (i%3==0) row.clear();
            for (int j = 3; j < 6; j++) {
                if (board[i][j]!='.'){
                    if (row.add(String.valueOf(board[i][j]))){}
                    else return false;
                }
            }
        }
        row.clear();

        for (int i = 0; i < 9; i++) {
            if (i%3==0) row.clear();
            for (int j = 6; j < 9; j++) {
                if (board[i][j]!='.'){
                    if (row.add(String.valueOf(board[i][j]))){}
                    else return false;
                }
            }
        }





//        for (char[] s : board){
//            for (char c : s){
//                if (c!='.'){
//                    if (row.add(String.valueOf(c))){}
//                    else return false;
//                }
//            }
//            row.clear();
//        }

        return true;
    }

}