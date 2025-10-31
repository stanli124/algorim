import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactars {
    public static void main(String[] args) {
        LSolution2 lSolution2 = new LSolution2();
        System.out.println(lSolution2.lengthOfLongestSubstring(" "));
    }
}

class LSolution2 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int right = i;
            Set<Character> characterSet = new HashSet<>();
            while (right < s.length()) {
                if (characterSet.contains(s.charAt(right))) {
                    if (characterSet.size() > ans) ans = characterSet.size();
                    break;
                } else {
                    characterSet.add(s.charAt(right));
                }
                right++;
            }
            if (characterSet.size() > ans) ans = characterSet.size();
        }
        return ans;
    }


}