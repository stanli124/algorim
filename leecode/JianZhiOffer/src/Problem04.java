public class Problem04 {


//            [
//            [1,   4,  7, 11, 15],
//            [2,   5,  8, 12, 19],
//            [3,   6,  9, 16, 22],
//            [10, 13, 14, 17, 24],
//            [18, 21, 23, 26, 30]
//            ]

    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int rowLen = matrix.length;
            if (rowLen == 0) return false;
            int colLen = matrix[0].length;
            if (colLen == 0) return false;

            int rowIndex = 0;
            int colIndex = 0;
            while (colIndex < colLen) {
                if (matrix[0][colIndex] > target) {
                    break;
                } else if (matrix[0][colIndex] == target) {
                    return true;
                }
                colIndex++;
            }

            while (rowIndex < rowLen) {
                if (matrix[rowIndex][colIndex - 1] == target) {
                    return true;
                }
                rowIndex++;
            }

            return false;
        }

        public boolean findNumberIn2DArray2(int[][] matrix, int target) {
            int rowLen = matrix.length;
            if (rowLen == 0) return false;
            int colLen = matrix[0].length;
            if (colLen == 0) return false;
            int x = 0;
            int y = colLen-1;
            while (x < rowLen && y >= 0) {
                if (matrix[x][y] == target) {
                    return true;
                } else if (matrix[x][y] > target) {
                    y--;
                } else {
                    x++;
                }
            }

            return false;
        }

    }

    public static void main(String[] args) {
        Problem04 problem04 = new Problem04();
        Solution solution = problem04.new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[][]{{}}, 1));
    }

}
