public class Problem53ii {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] findMissingNum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            findMissingNum[nums[i]] = 1;
        }
        for (int i = 0; i < findMissingNum.length; i++) {
            if (findMissingNum[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
