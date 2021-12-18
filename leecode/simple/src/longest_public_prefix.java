import java.util.Arrays;
import java.util.concurrent.TransferQueue;

/**
 * 查找字符串数组中最长公共前缀，若不存在公共前缀，返回空字符串“”；
 * 从最短的开始
 */

public class longest_public_prefix {

    public static void main(String[] args) {
        String[] strs = {"flow", "flower", "flight"};

        long start = System.currentTimeMillis();
        System.out.println(longestCommonPrefix(strs));
        long end = System.currentTimeMillis();

        System.out.println((end - start) + " ms");
    }

    public static String longestCommonPrefix(String[] strs){
//        //自己的方法：先找出最短的字符串，并以此字符串的第一个字符开始匹配；若全部都有该字符，则取该字符串的前两个字符开始匹配，若满足则继续；若不满足都有该字符串则返回，已有的最长公共前缀字符串；
//        int idx = 0;   //保存最短字符串的索引
//        int l = 1000;
//        for (int i = 0; i < strs.length; i++) {
//            if (strs[i].length() < l) {idx=i;l=strs[i].length();}
//        }
//
//        String lon_str = "";
//        StringBuffer sub_str = new StringBuffer();
//        for (int i = 1; i <= strs[idx].length(); i++) {
//            sub_str.delete(0, sub_str.length());
//            sub_str.append(strs[idx].substring(0, i));   //取出前缀字符串；
//
//            for (int j = 0; j < strs.length; j++) {
//                if (sub_str.toString().equals(strs[j].substring(0,i))){
//                    if (j == strs.length - 1) lon_str = sub_str.toString();   //若所有字符串都有该前缀，则记录目前的最长公共前缀；
//                }else break;
//            }
//
//        }
//
//        return lon_str;




//        //先把字符串数组进行排序, 然后取出第一个字符串以及最后一个字符串进行比较；因为排序之后，这两个字符串的差异最大，只需要比较这两就行了；
//        String lon_str = "";
//        Arrays.sort(strs);
//        String startStr = strs[0];
//
//        for (int i = 0; i < startStr.length() && i < strs[strs.length -1].length(); i++) {
//            if (startStr.substring(0, i+1).equals(strs[strs.length -1].substring(0, i+1))){
//                lon_str = startStr.substring(0, i+1);
//            }else break;
//        }
//        return lon_str;


        //随机选择一个字符串，这里选择第一个字符串
        if (strs.length == 0) return "";
        StringBuffer sb = new StringBuffer(strs[0]);

        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].startsWith(sb.toString())) {}
            else {
                while (!strs[i].startsWith(sb.toString()) && sb.length()>=0)
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

}
