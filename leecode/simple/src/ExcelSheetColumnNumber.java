public class ExcelSheetColumnNumber {

    class Solution {
        public int titleToNumber(String columnTitle) {
            if (columnTitle.length()>7 || columnTitle.length()<=0 || columnTitle==null) return 0;
            int res = 0;
            int digit=1;
            char[] cs = columnTitle.toCharArray();
            for (int i = columnTitle.length()-1; i>=0; i--) {
                int temp = cs[i] - 'A' + 1;
                res += temp*digit;
                digit *= 26;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        Solution solution = e.new Solution();
        System.out.println(solution.titleToNumber("AAA"));
    }

}



