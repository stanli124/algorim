/** 统计特殊四元组
 *
 */

package code;

public class special_four_tuple {

    public static void main(String[] args) {


        System.out.println(countQuadruplets(new int[]{1,1,1,3,5}));

    }

    public static int countQuadruplets(int[] nums) {
        System.out.println(nums[0]);
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    for (int l = k+1; l < len; l++) {
                        if (nums[i] + nums[j] +nums[k] == nums[l]) count++;
                    }
                }
            }
        }
        return count;
    }

}
