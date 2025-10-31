import java.util.List;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0};
        MSolution mSolution = new MSolution();
        mSolution.moveZeroes2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

class MSolution {
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        int nonZeroPointer = 0;

        while (zeroPointer < nums.length && nonZeroPointer < nums.length && zeroPointer <= nonZeroPointer) {
            while (zeroPointer < nums.length && nums[zeroPointer] != 0) zeroPointer++;
            while (nonZeroPointer < nums.length && nums[nonZeroPointer] == 0) nonZeroPointer++;
            if (zeroPointer < nums.length && nonZeroPointer < nums.length && zeroPointer <= nonZeroPointer) {
                nums[zeroPointer] = nums[nonZeroPointer];
                nums[nonZeroPointer] = 0;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
            right++;
        }

        for (int i = left; i < nums.length; i++) {
            nums[left++] = 0;
        }

    }
}
