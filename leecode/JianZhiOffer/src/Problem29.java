public class Problem29 {

    public static void main(String[] args) {

    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { // 若为空则返回空数组
            return new int[]{0};
        }

        int row = 0;
        int col = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols]; // 用来保存顺时针遍历的数字
        boolean[][] used = new boolean[rows][cols]; // 用来表示当前元素是否已经访问过
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 向右 向下 向左 向上
        int directionIndex = 0;

        for (int i = 0; i < rows * cols; i++) {

            res[i] = matrix[row][col]; // 顺时针旋转，将当前元素添加到res数组中
            used[row][col] = true;

            // 判断下一个位置 是否越界
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || used[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4; // 若越界 则换一个方向
            }
            row = directions[directionIndex][0] + row;
            col = directions[directionIndex][1] + col;

        }
        return res;
    }

}
