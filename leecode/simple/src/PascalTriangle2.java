import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {

    class Solution {
        public List<Integer> getRow(int rowIndex) {
//            List<List<Integer>> arrayList = new ArrayList<>();
//            arrayList.add(Arrays.asList(0,1,0));
//            arrayList.add(Arrays.asList(0,1,1,0));
//            for (int i = 2; i <= rowIndex; i++) {
//                List<Integer> lastRow = arrayList.get(i - 1);
//                ArrayList<Integer> curRow = new ArrayList<>(); //首尾各多一个位置为0
//                curRow.add(0);
//                for (int j = 0; j < lastRow.size()-1; j++) {   //遍历到最后一个元素的前一个位置
//                    curRow.add(lastRow.get(j) + lastRow.get(j+1)); //两个元素相加得到下一个元素的值
//                }
//                curRow.add(0);
//                arrayList.add(curRow);
//            }
//            List<Integer> row = arrayList.get(rowIndex);
//            return row.subList(1, row.size()-1);

            List<List<Integer>> arrayList = new ArrayList<>();
            arrayList.add(new ArrayList<>(Arrays.asList(0,1,0)));   //Arrays.asList返回的是内部类，实现了AbstractList，该实现类没有remove方法；与java类库中的ArrayList不同
            arrayList.add(new ArrayList<>(Arrays.asList(0,1,1,0)));
            for (int i = 2; i <= rowIndex; i++) {
                List<Integer> lastRow = arrayList.get(i - 1);
                ArrayList<Integer> curRow = new ArrayList<>(); //首尾各多一个位置为0
                curRow.add(0);
                for (int j = 0; j < lastRow.size()-1; j++) {   //遍历到最后一个元素的前一个位置
                    curRow.add(lastRow.get(j) + lastRow.get(j+1)); //两个元素相加得到下一个元素的值
                }
                curRow.add(0);
                arrayList.add(curRow);
            }
            List<Integer> row = arrayList.get(rowIndex);
            row.remove(row.size()-1);
            row.remove(0);
            return row;
        }
    }

    public static void main(String[] args) {
        PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
        Solution solution = pascalTriangle2.new Solution();
        System.out.println(solution.getRow(1));
    }

}
