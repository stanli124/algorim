package search;

import java.util.Arrays;

public class binarySearch {

    public static void main(String[] args) {
//        int[] nums = new int[]{23,56,8,3,2,2,3,1,1,4,5,1,2,8,9,21,45,78,90,23};
        int[] nums = new int[]{1,1,1,1,2,3,4,5,7,8,9,11,23};
        Arrays.sort(nums);
        System.out.println(leftBinary(nums, 1));
    }

    //普通的二分查找
    public static int binary(int[] nums, int target){
        int left = 0, right = nums.length-1;

        while (left <= right){
            int mid = left + (right - left) / 2; //避免因直接相加超出表示范围
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //寻找左侧边界的二分查找
    public static int leftBinary(int[] nums, int target){
        int left = 0, right = nums.length-1;;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){  //相等的时候不返回，锁定左侧边界
                right = mid - 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        //这里检查left>=nums.length是因为如果查找的target比所有元素都大，那么left会一直遍历到right+1，所以要判断。
        if (left >= nums.length || nums[left] != target) return -1;

        return left;
    }

}
