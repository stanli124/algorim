package JianZhiOffer;

//扑克牌中的顺子

import java.util.Arrays;
import java.util.HashSet;

public class Q61 {

    public static void main(String[] args) {



    }

    //过不完
//    public boolean isStraight(int[] nums){
//        int[] data = new int[14];
//        Arrays.sort(nums);
//        int canChange = 0;
//        if (nums[0] == 0) canChange++;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == 0) canChange++;
//            else if (nums[i] != nums[i-1]+1){
//                if (canChange==0) return false;
//                int num = nums[i-1];
//                nums[i] = num + 1;
//                nums[canChange-1] = num;
//                canChange--;
//                --i;
//            }
//        }
//        return true;
//    }

    public boolean isStraight(int[] nums){
        int min = 14;
        int max = -1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (set.contains(nums[i])) return false;
            set.add(nums[i]);
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        return max - min < 5;
    }


}
