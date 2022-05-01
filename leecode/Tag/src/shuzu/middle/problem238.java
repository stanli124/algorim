package shuzu.middle;

public class problem238 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        problem238 a = new problem238();

        int[] res = a.productExceptSelf(nums);

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

}
