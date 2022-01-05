/** z字形变换
 *  给定一个字符串s根据给定的行数numRows，以从上往下，从左到右进行z字形排列；
 */


package zifuchuan.middle;

import java.util.ArrayList;
import java.util.List;

public class problem6 {


    public static void main(String[] args) {
        System.out.println(convert("ABCDE", 3));
    }

    public static String convert(String s, int numRows) {
//        if (s.length()==1 || numRows==1) return s;
//        int[][] zTrans = new int[numRows][30];
//        int direction = 0;
//        int layers = 0;
//        int[] rows = new int[numRows];
//
//        for (int i = 0; i < s.length(); i++) {
//            if (direction == 0){
//                zTrans[layers][rows[layers]++] = s.charAt(i);
//                layers++;
//                if (layers>=numRows-1) {
//                    if (layers > numRows -1 ) layers = numRows - 1;
//                    direction=1;
//                }
//            }
//            else {
//                if (layers==0) {
//                    direction=0;
//                    zTrans[layers][rows[layers]++] = s.charAt(i);
//                    layers++;
//                    continue;
//                }
//                zTrans[layers][rows[layers]++] = s.charAt(i);
//                layers--;
//            }
//        }
//        StringBuffer sb = new StringBuffer();
//        for(int[] arr : zTrans){
//            int i = 0;
//            while (arr[i]!=0){
//                sb.append((char)arr[i++]);
//            }
//        }
//        return sb.toString();

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();


    }


}
