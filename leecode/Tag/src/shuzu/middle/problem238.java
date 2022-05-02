package shuzu.middle;

public class problem238 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        problem238 a = new problem238();

        int[] res = a.productExceptSelf(nums, 1);

        for (int i = 0; i < res.length; i++) {
            System.out.printf(res[i] + " ");
        }

    }

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                int num = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (j==i)continue;
                    num = num * nums[j];
                }
                res[i] = num;
                continue;
            }
            res[i] = product / nums[i];
        }
        return res;
    }


    public int[] productExceptSelf(int[] nums, int k){
        int len = nums.length;

        int[] L = new int[len]; //代表当前索引i处，左边所有元素的乘积
        int[] R = new int[len]; //代表当前索引i处，右边所有元素的乘积

        L[0] = 1; //索引0处左边没有元素，所以值为1；
        for (int i = 1; i < len; i++) {
            L[i] = L[i-1] * nums[i-1];
        }

        R[len-1] = 1;
        for (int i = len-2; i>=0; i--) {
            R[i] = R[i+1] * nums[i+1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = L[i] * R[i];
        }

        return nums;
    }



}
