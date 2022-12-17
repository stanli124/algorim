package JianZhiOffer;

public class Q53_2 {
//0~n-1中缺失的数字；
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 3}));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length + 1;
        boolean[] res = new boolean[n];
        for (int i = 0; i < n-1; i++) {
            if (nums[i] < n) res[nums[i]] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!res[i]) return i;
        }
        return -1;
    }

}
