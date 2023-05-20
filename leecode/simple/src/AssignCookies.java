import java.util.Arrays;

public class AssignCookies {

    class Solution{
        public int findContentChildren(int[] g, int[] s){
            Arrays.sort(g);
            Arrays.sort(s);
            int ans = 0;
            int i=0,j=0;

            while (i < g.length && j < s.length){
                if (g[i] <= s[j]){
                    ans++;
                    i++;
                    j++;
                }else {
                    j++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        Solution solution = assignCookies.new Solution();
        System.out.println(solution.findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8}));
    }

}
