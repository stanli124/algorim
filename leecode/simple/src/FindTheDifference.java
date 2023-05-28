import java.util.HashMap;
import java.util.Set;

public class FindTheDifference {

    class Solution{
        public char findTheDifference(String s, String t){

            HashMap<Character, Integer> mapS = new HashMap<>();
            HashMap<Character, Integer> mapT = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char cs = s.charAt(i);
                char ct = t.charAt(i);
                mapS.put(cs, mapS.getOrDefault(cs, 0)+1);
                mapT.put(ct, mapT.getOrDefault(ct, 0)+1);
            }
            mapT.put(t.charAt(t.length()-1), mapT.getOrDefault(t.charAt(t.length()-1),0)+1);

            Set<Character> characterSet = mapT.keySet();
            for (char c : characterSet){
                if (!mapS.containsKey(c)) return c;
                if (mapT.get(c) > mapS.get(c)) return c;
            }
            return ' ';
        }
    }

    public static void main(String[] args) {
        FindTheDifference findTheDifference = new FindTheDifference();
        Solution solution = findTheDifference.new Solution();
        System.out.println(solution.findTheDifference("", "u"));
    }

}
