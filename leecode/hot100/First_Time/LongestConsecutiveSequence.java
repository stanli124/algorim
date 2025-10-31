import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 2};
        LSolution solution = new LSolution();
        System.out.println(solution.longestConsecutive(nums));
    }
}

class LSolution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int count = 1;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
                if (count >= maxLength) {
                    maxLength = count;
                }
            } else if (nums[i - 1] == nums[i]) {

            } else {
                count = 1;
            }
        }
        return maxLength;
    }


    // 官方解法
    public int longestConsecutive2(int[] nums)  {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestLength = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength += 1;
                }

                longestLength = Math.max(longestLength, currentLength);
            }
        }

        return longestLength;
    }
}
