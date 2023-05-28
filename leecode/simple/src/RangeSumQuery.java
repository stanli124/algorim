public class RangeSumQuery {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 5));
    }

}


class NumArray{
    int[] nums = null;
    public NumArray(int[] nums){
        this.nums = nums;
    }

    public int sumRange(int left, int right){
        int count = 0;
        if (left > right || left < 0) return 0;

        for (int i = left; i <= right; i++) {
            count += nums[i];
        }

        return count;
    }

}