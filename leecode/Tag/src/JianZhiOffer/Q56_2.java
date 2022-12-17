package JianZhiOffer;

//数组中数字出现的次数2

public class Q56_2 {
    public int singleNumber(int[] nums){
        int[] counts = new int[32]; //用来保存每一位上1出现的次数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                counts[j] = counts[j] + (nums[i]&1); //counts左边保存低位，右边保存你高位
                nums[i] >>>= 1;
            }
        }

        for (int i = 0; i < 32; i++) {
            counts[i] = counts[i] % 3;
        }

        //恢复数字
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res = res | counts[31 - i]; //从高位开始恢复
        }
        return res;
    }
}
