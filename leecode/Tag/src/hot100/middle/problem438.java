package hot100.middle;

import java.util.*;

public class problem438 {
    HashSet<Character> a;

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        problem438 b = new problem438();
        System.out.println(b.findAnagrams(s, p));
    }


    //只能过一半
//    public List<Integer> findAnagrams(String s, String p) {
//
//        a = new HashSet<>();
//
//
//        int len = p.length();
//        List<Integer> res = new LinkedList<>();
//        for (int i = 0; i <= s.length()-len; i++) {
//            String subString = s.substring(i, i+len);
//            for (char c : p.toCharArray()){
//                a.add(c);
//            }
//            if (isAnagrams(subString)){
//                res.add(i);
//            }
//            a.clear();
//        }
//        return res;
//    }
//
//    public boolean isAnagrams(String subS){
//        for (int i = 0; i < subS.length(); i++) {
//            if (a.contains(subS.charAt(i))){
//                a.remove(subS.charAt(i));
//                continue;
//            }else {
//                return false;
//            }
//        }
//        return true;
//    }


    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        //处理索引0处的情况
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        //滑动窗口：出第一个字符，进一个字符
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
