package sort;

public class quickSort {

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,4,5,2,2,1,7,9,33,5,22,11,3,0,9};
        qSort(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i] + " ");
        }
    }

    public static void qSort(int[] nums, int low, int high){
//        int low = 0, high = nums.length - 1;
        if (low >= high)
            return;
        int p = partition(nums, low, high);

        qSort(nums, low, p-1);
        qSort(nums, p+1, high);

    }

    public static int partition(int[] subNums, int low, int high){
        int pivot = subNums[low];  //也有暂存值的作用
        while (low < high)
        {
            //一定要从右边开始找小于pivot的数，因为high的值没有保存，一开始low的值保存在pivot中
            while (low < high && subNums[high]>=pivot) high--; //从右边找到第一个比p小的数
            subNums[low] = subNums[high];
            while (low < high && subNums[low]<=pivot) low++; //从左边找到第一个比p大的数
            subNums[high] = subNums[low];
        }
        subNums[high] = pivot;  //到这里low=high，返回哪一个都是一样的
        return high;
    }


}
