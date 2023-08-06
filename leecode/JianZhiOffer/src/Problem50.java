import java.util.HashMap;
import java.util.Map;

public class Problem50 {
    public static void main(String[] args) {
        Problem50 problem50 = new Problem50();
        System.out.println(problem50.firstUniqChar("loveleetcode"));
    }

    public char firstUniqChar(String s) {
        Map<Character, int[]> map = new HashMap<>();

        int index = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int[] ints = map.get(c);
                ints[0] += 1;
                map.put(c, ints);
            } else {
                int[] ints = new int[]{0, 0};
                ints[0] = 1;
                ints[1] = index;
                map.put(c, ints);
            }
            index++;
        }

        int firstCharIndex = -1;
        int curCharIndex = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            int[] ints = map.get(c);
            if (ints[0] == 1 && ints[1] < curCharIndex) {
                firstCharIndex = ints[1];
                curCharIndex = ints[1];
            }
        }
        if (firstCharIndex == -1) {
            return ' ';
        }
        return s.charAt(firstCharIndex);
    }
}
