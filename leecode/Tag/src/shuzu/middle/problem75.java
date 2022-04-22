/**
 * 颜色分类
 * 给定一个包含红色、白色、蓝色，
 * 共n个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 */

package shuzu.middle;

public class problem75 {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,0,0};
        quickSort(0, a.length-1, a);
        for (int s : a){
            System.out.printf(s+" ");
        }
    }

    public static void quickSort(int low, int high, int[] nums){
        if (low>=high) return;

        int parition = parition(low, high, nums);
        quickSort(low, parition-1, nums);
        quickSort(parition+1, high, nums);

    }

    public static int parition(int low, int high, int[] nums){
        int pviot = nums[low];

        //从右边找到第一个比 pviot 小的
        while (low < high) {
            while (low < high && nums[high] >= pviot) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pviot) low++;
            nums[high] = nums[low];
        }

        nums[low] = pviot;
        return low;
    }


}
