/** 搜索旋转排序数组
 *  整数数组升序排序，数组中的值互不相同
 *  该数组在某个下标处进行了旋转，该下标不会给出是未知的。
 */

package shuzu.middle;

public class problem33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int len = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){ //等于直接返回下标
                return mid;
            } else if (nums[mid] >= nums[0]) { //中间值 大于 第一个值：说明从开头到mid是升序，另一边不是升序
                if (nums[0] <= target && target <= nums[mid]){ //target在的值处于有序的中间
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[len]){ //中间值 小于 最后一个元素：说明从mid到最后是升序，另一边不是升序
                if (nums[mid] <= target && target <= nums[len]){ //target在的值处于有序的中间
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }
        return -1;

//        int left = 0, right = nums.length - 1;
//        while(left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            } else if(nums[mid] == target) {
//                // 直接返回
//                return mid;
//            }
//        }
//        // 直接返回
//        return -1;

    }

}
