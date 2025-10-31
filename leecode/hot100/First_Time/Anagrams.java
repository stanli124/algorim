import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"a"};
        System.out.println(solution.groupAnagrams(strs));
    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortStrMap = new HashMap<>();
        if (strs.length <= 1) {
            List<List<String>> res = new ArrayList<>();
            res.add(List.of(strs));
            return res;
        }

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedString = new String(array);
            List<String> stringList = sortStrMap.getOrDefault(sortedString, new ArrayList<>());
            stringList.add(str);
            sortStrMap.put(sortedString, stringList);
        }

        return new ArrayList<>(sortStrMap.values());
    }

    public Set<Character> getCharSet(String str) {
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
        }
        return characters;
    }
}