package JianZhiOffer;

import java.util.HashMap;

public class Q56_1 {
//数组中数字出现的次数
//    public int[] singleNumbers(int[] nums) {
//        HashMap<Integer, Boolean> twoNum = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (twoNum.containsKey(nums[i])){
//                twoNum.put(nums[i], true);
//            }else {
//                twoNum.put(nums[i], false);
//            }
//        }
//
//        int[] res = new int[2];
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (!twoNum.get(nums[i])){
//                res[index++] = nums[i];
//            }
//        }
//        return res;
//    }

    public int[] singleNumbers(int[] nums) {
        //时间复杂度为On，空间复杂度为O1；使用了位运算
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums){
            n ^= num;
        }
        while ((n & m)==0){
            m <<= 1;
        }
        for (int num : nums){
            if ((num & m) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x,y};
    }

}
