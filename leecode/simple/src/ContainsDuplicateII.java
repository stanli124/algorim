import java.util.*;

public class ContainsDuplicateII {

    class Solution {
        /**
         * 给定一个整数数组nums和一个整数k，判断数组中是否存在两个 不同的索引i和j，满足num[i]==nums[j] && abs(i-j)<=k
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            //这个方法超时了
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] == nums[j] && Math.abs(i-j) <= k){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean containsNearbyDuplicate2(int[] nums, int k) {

            //遍历数组，将有相同值的索引放到一起
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])){
                    map.get(nums[i]).add(i);
                }else {
                    map.put(nums[i], new ArrayList<Integer>());
                    map.get(nums[i]).add(i);
                }
            }

            //取出所有key，按照key遍历
            Set<Integer> integers = map.keySet();
            for (Integer key : integers){
                if (map.get(key).size() == 0) continue;
                List<Integer> indexList = map.get(key);
                for (int i = 0; i < indexList.size(); i++) {
                    for (int j = i+1; j < indexList.size(); j++) {
                        if (Math.abs(indexList.get(i)-indexList.get(j)) <= k){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        Solution solution = containsDuplicateII.new Solution();
        System.out.println(solution.containsNearbyDuplicate2(new int[]{1,2,3,1}, 3));
    }

}
