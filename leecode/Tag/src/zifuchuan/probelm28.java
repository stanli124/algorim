/** 实现strStr()
 *  给定两个字符串 haystack 和 needle，请在haystack字符串中找出needle字符串出现的第一个位置（下标从0开始）。如果不存在，则返回-1。
 *
 */

package zifuchuan;

public class probelm28 {

    public static void main(String[] args) {
        String haystack = "aaa";
        String needle = "aaaa";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
//        return  haystack.indexOf(needle);
        int ha_len = haystack.length();
        int ne_len = needle.length();
        int count = 0;

        if (ha_len==0 && ne_len==0) return 0;
        if (ne_len == 0) return 0;
        if (ha_len == 0) return 0;
        if (ne_len > ha_len) return -1;

        for (int i = 0; i < ha_len; i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                count+=1;
                for (int j = 1, idx=i; j < ne_len; j++,idx++) {
                    if (haystack.charAt(idx)==needle.charAt(j)) count++;
                    else {
                        count = 0;
                        break;
                    }
                }
                if (count == ne_len) return i;
            }

        }

        return -1;
    }

}
