/** 最长的美好子字符串
 *  给定一个字符串s，请返回s的最长美好字符串；若有多个答案，则返回最早出现的一个，如果不存在美好字符串，就返回一个空字符串；
 *  当一个字符串s包含的 每一种字母的大写和小写形式 同时 出现在s中，s就称为美好字符串。'abABB'就是美好字符串，因为a和A，b和B同时出现了。
 */

package zifuchuan;

//import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class probelm1763 {

    public static void main(String[] args) {
        String s = "ffsdfsdFSD";
        System.out.println(longestNiceSubstring(s));

    }

    public static String longestNiceSubstring(String s) {
//        int len = s.length();
//        if (len < 2) return "";
//
//        List<String> meiHao = new ArrayList<>();
//        StringBuffer subStr = new StringBuffer();
//        boolean flag = true;
//
//        for (int i = 0; i < len; i++) {
//            subStr.append(s.charAt(i));
//
//            for (int j = i+1; j < len; j++) {
//
//                for (int k = 0; k < subStr.length(); k++) {
//                    int sub = subStr.charAt(k) - s.charAt(j);
//                    if (sub!=32 && sub!=-32 && sub!=0){
//                        flag = false;
//                        break;
//                    }
//                }
//
//                if (flag){
//                    subStr.append(s.charAt(j));
//                }else {
//                    break;
//                }
//
//            }
//
//
//
//            if (subStr.length()>1) {
//                meiHao.add(subStr.toString());
//                i+=subStr.length();
//            }
//            flag=true;
//            subStr.delete(0, subStr.length());
//
//
//        }
//
//        if (meiHao.size()==0) return "";
//
//        return meiHao.get(0);
        int len = s.length();
        int idx = 0;
        if (len < 2) return "";

        LinkedHashSet<Character> lower = new LinkedHashSet<Character>();
        LinkedHashSet<Character> upper = new LinkedHashSet<Character>();

        for (int window = len; window >= 2; window--) {

            for (int j = 0; j <= len-window; j++) {

                String subStr = s.substring(j, j+window);
                for (int i = 0; i < subStr.length(); i++) {
                    if (Character.isUpperCase(subStr.charAt(i))) upper.add(subStr.charAt(i));
                    else lower.add(Character.toUpperCase(subStr.charAt(i)));
                }

                if (lower.size() == upper.size()){
                    upper.removeAll(lower);
                    if (upper.size()==0) return subStr;
                }
                lower.clear();
                upper.clear();



            }

        }
        return "";
    }


}
