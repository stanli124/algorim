/** 给你一个数组nums 和 一个值val，你需要原地移除所有数值等于val的元素，并返回移除后的数组的新长度。
 *
 */

package doublePoint.easy;

public class problem27 {

    public static void main(String[] args) {

        System.out.println(removeElement(new int[]{4,5}, 5));

    }

    public static int removeElement(int[] nums, int val) {
//        int l = 0;
//        int r = nums.length - 1;
//
//        if (nums.length==1){
//            return nums[0]==val?0:1;
//        }
//
//        while(l < r){
//            while(l < r && nums[r] == val) r--; //找到和val不相等的元素
//            while(l < r && nums[l] != val) l++; //找到和val相等的元素
//            if (l < r){
//                nums[l++] = nums[r--];
//            }
//        }
//
////        if (l==0 && r==0)return 0; //数组里面所有的值和val一样则返回0；
//
//        for (int i = 0; i <= r; i++) {
//            System.out.println(nums[i]);
//        }
//        System.out.println();
//
//        return l==0&&r==0?0:r+1;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

}
