/**
 * 题目：两数之和
 * 输入：整数数组nums和整数目标值target，在目标数组中找出 和为target的两个整数，并返回他们的数组下标
 * 只会存在一个有效答案;每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 */







public class sum_of_twonums {

    public static void main(String[] args) {
        int[] a = new int[]{3,2,95,4,-3};
        int[] b = twoSum(a,92);
        for (int s : b){
            System.out.println(s);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        int len_nums = nums.length;

        //没有解决数组同时包含正数、负数的情况
//        for (int i = 0; i < len_nums; i++) {
//            if ((target > 0) &&(nums[i] > target)) continue;
//
//            else {
//                for (int j = i + 1; j < len_nums; j++) {
//                    if (nums[i] + nums[j] == target) {
//                        index[0] = i;
//                        index[1] = j;
//                        return index;
//                    }
//                }
//
//            }
//        }


        for (int i = 0; i < len_nums; i++) {
                for (int j = i + 1; j < len_nums; j++) {
                    if (nums[i] + nums[j] == target) {
                        index[0] = i;
                        index[1] = j;
                        return index;
                    }
                }
        }


        return index;
    }
}
