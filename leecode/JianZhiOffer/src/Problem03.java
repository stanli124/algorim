import java.util.HashSet;

public class Problem03 {
    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> isExist = new HashSet<>();
        for (int num : nums) {
            if (isExist.contains(num)){
                return num;
            } else {
                isExist.add(num);
            }
        }
        return 0;
    }

}
