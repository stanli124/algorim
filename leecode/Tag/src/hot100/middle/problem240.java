package hot100.middle;

public class problem240 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        problem240 a = new problem240();
        System.out.println(a.searchMatrix(matrix, 20));
    }
//自己的做法：对每一行进行二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = m-1; i >= 0; i--) {
            if (target >= matrix[i][0]){
                if (binarySearch(matrix[i], 0, n-1, target)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean binarySearch(int[] nums, int low, int high, int target){

        while (low <= high){
            int mid = low + (high-low)/2; //防止下标溢出
            if (target == nums[mid]){
                return true;
            }else if (target > nums[mid]){
                low = mid + 1;
            }else if (target < nums[mid]){
                high = mid - 1;
            }
        }

        return false;
    }

//z字形搜索
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int x = 0, y = n - 1;
//
//        while (x < m && y >= 0){
//            if (target < matrix[x][y]){
//                //大于target，那么这一整列都大于，往前移动一列
//                y--;
//            }else if (target == matrix[x][y]){
//                return true;
//            }else if (target > matrix[x][y]){
//                //小于target，向下移动一行
//                x++;
//            }
//        }
//        return false;
//    }


}
