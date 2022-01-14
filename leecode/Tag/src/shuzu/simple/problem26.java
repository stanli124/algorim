/** 删除有序数组中的重复项
 *  给你一个有序数组nums，请原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 *  不要使用额外的数组空间，在原地修改输入数组并在使用O(1)额外空间的条件下完成
 *
 */

package shuzu.simple;

public class problem26 {

    public static void main(String[] args) {

        int[] a = new int[]{1,1,0,0,2,2,2,2,2,2,2};
        int len = removeDuplicates(a);
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        if (nums.length==0) return 0;

        while (j < nums.length-1){
            if (nums[j] == nums[j+1]) {
                j++;
            }else{ //前一个和后一个不相同；
                nums[i++] = nums[j++];
            }
        }
        nums[i] = nums[j];

        return i+1;
    }

}
