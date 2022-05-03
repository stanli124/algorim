/**
 * 回文子串
 * 给你一个字符串s，请统计并返回这个字符串中回文子串的数量
 */

package hot100.middle;

public class problem647 {

    public static void main(String[] args) {
        String s = "aaa";
        problem647 a = new problem647();

        System.out.println(a.countSubstrings(s));

    }


    //暴力循环
//    public int countSubstrings(String s) {
//        int len = s.length();
//        int count = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1; j <= len; j++) {
//                String subString = s.substring(i, j);
//                if (isHuiwen(subString)){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public boolean isHuiwen(String subString){
//        int start = 0;
//        int end = subString.length()-1;
//
//        while (start <= end){
//            if (subString.charAt(start++) != subString.charAt(end--)) return false;
//        }
//        return true;
//    }


    //把每个索引当成回文中心，从中心向四周进行扩散
    public int countSubstrings(String s){
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=1 ; j++) {
                int left = i;
                int right = i+j;
                while (left>=0 && right<n && s.charAt(left--)==s.charAt(right++)) num++;
            }
        }

        return num;
    }





}
