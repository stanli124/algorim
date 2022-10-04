package JianZhiOffer;

public class Q53_1 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int pre = 0;
        int last = nums.length - 1;
        while (pre < nums.length && nums[pre] != target) pre++;
        while (last >= 0 && nums[last] != target) last--;
        if (pre <= last) return last - pre +1;
        return 0;
    }

}
