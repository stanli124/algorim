import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagrams {
    public static void main(String[] args) {
        A2Solution a2Solution = new A2Solution();
        String s = "aa";
        String p = "bb";
        List<Integer> anagrams = a2Solution.findAnagrams(s, p);
        System.out.println(anagrams);
    }
}

class A2Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26], pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a'] += 1;
            pCount[p.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

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