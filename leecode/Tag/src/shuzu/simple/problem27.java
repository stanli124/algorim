/** 移除元素
 *  给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度
 */

package shuzu.simple;

public class problem27 {

    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,2,3,0,4,2};
        int b =removeElement(a, 2);
        System.out.println(b);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if ((i+1) % b ==0 && i > 0) System.out.println();
        }
    }

    public static int removeElement(int[] nums, int val) {
        int delValue = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==val){
                nums[i] = 0;
                delValue--;
            }
        }

        int idx = delValue-1;
        for (int i = delValue; i < nums.length; i++) {
            if (nums[i]==0)continue;
            else {
                while (idx >= 0 && nums[idx]!=0){
                    idx--;
                }
                nums[idx--] = nums[i];
                nums[i] = 0;
            }
        }


        return delValue;
    }

}
