package sort;

public class mergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,5,6,3,88,67,6,5,66,3};
        sort(a, 0 ,a.length-1);

        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i]+" ");
        }
    }

    public static void sort(int[] nums, int low, int high){
        if (low >= high){
            return;
        }
        int mid = low + (high - low) / 2;

        //对左右子序列进行排序；
        sort(nums, low, mid);
        sort(nums, mid+1, high);

        //这时候左右子序列都已经有序，合并两个有序数组；
        merge(nums, low, mid, high);

        return;
    }

    public static void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high-low + 1]; //辅助数组，先把所有值赋值到该数组中。
        int i = low,j=mid+1;
        for (int k = 0; k < temp.length; k++) {
            if (i==mid+1){  //左边的已经已经添加完了，把右边剩下的添加进来。
                temp[k] = nums[j++];
            }else if (j==high+1){ //右边的添加完，把左边剩下的添加进来。
                temp[k] = nums[i++];
            }else if (nums[i] > nums[j]){
                temp[k] = nums[j++];
            }else {
                temp[k] = nums[i++];
            }
        }
        for (int k = low, l=0; k <= high; k++) { //把辅助数组中有序的结果放到真正的数组中
            nums[k] = temp[l++];
        }
    }


}
