/** 外观数列
 *
 */
//将字符串分割为 最小数量的组；每个组都由连续的 最多相同字符组成
//对于每个组，先描述字符的数量，然后描述字符
package zifuchuan.middle;

import java.util.LinkedList;
import java.util.List;

public class problem38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(20));
    }

//    public static String countAndSay(int n) {
//        String[] Strs = new String[n+1];
//        Strs[1] = "1";
//        describe(n, Strs);
//        return Strs[n];
//    }
//
//    public static void describe(int n, String[] strs){
//        if(n==1) return ;
//        else describe(n-1, strs);
//
//        //取得前一个字符串，并对其进行描述。
//        String s = strs[n-1];
//        StringBuilder des = new StringBuilder(); //用来拼接每个组的描述,生成最后的描述
//        StringBuilder gruop = new StringBuilder();//用来保存每个组
//        gruop.append(s.charAt(0));
//        int idx = 0;
//        int idx_g = 0; //s的索引和组group的索引要分开，不然用同一个会报数组越界的错误
//        while (idx < s.length()){
//             //如果当前字符和前一个字符相等，就添加进当前组
//            if (s.charAt(idx) == gruop.charAt(idx_g++)){
//                gruop.append(s.charAt(idx++));
//            }else { //当前字符和前一个字符不等，就处理当前组。并生成描述。
//                des.append(gruop.length()-1);
//                des.append(gruop.charAt(1));
//                gruop.delete(0, gruop.length());
//                gruop.append(s.charAt(idx));
//                idx_g = 0;
//            }
//        }
//
//        if (gruop.length() > 0){ //当到最后一个组的时候，会退出while循环，但是des还有最后一个字符串
//            des.append(gruop.length()-1);
//            des.append(gruop.charAt(1));
//        }
//
//        strs[n] = des.toString();
//    }

    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) { //循环一遍需要生成描述的字符串
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) { //当前组的数量
                    pos++;   //先找到字符串中当前组相同的字符的个数，start表示当前组的第一个字符
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));//先添加相同字符数量，再添加字符
                start = pos; //记录当前组的起始位置
            }
            str = sb.toString();
        }

        return str;
    }


}
