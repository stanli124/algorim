package shuzu.hard;

public class problem493 {
    int count = 0;
    int[] temp;
    public static void main(String[] args) {
        int[] a = new int[]{1,3,2,3,1};
        problem493 b = new problem493();
        System.out.println(b.reversePairs(a));
    }

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return count;
    }

    public void sort(int[] nums, int low, int high){
        if (low >= high){
            return; //只有一个元素的时候不用排序直接返回
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);

        merge(nums, low, mid, high);

    }

    public void merge(int[] nums, int low, int mid, int high){
        //把当前给定范围内需要排序的数值 复制到 辅助数组中
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        //自己写的有问题
//        int i = low, j = high;
//        while (i<=mid || j>=mid+1){
//            if (nums[i] > nums[j]*2){
//                count += (mid-i+1)*(j-mid);
//                break;
//            }else if (i <= mid && nums[i] <= nums[j]*2){
//                i++;
//            }else if (j >= mid+1 && nums[i] <= nums[j]*2){
//                j--;
//            }
//        }

        int end = mid + 1;
        for (int i = low; i <= mid; i++) {
            //nums中元素可能较大，所以*2可能溢出。
            while (end <= high && (long)nums[i] > (long)nums[end]*2){
                end++;
            }
            count += end - (mid+1);
        }

        int i = low, j = mid+1;
        for (int k = low; k <= high; k++) {
            if (i == mid+1){    //这里前面两个 必须在后面两个之前进行判断；否则后半部分会赋值不正确
                nums[k] = temp[j++];
            }else if (j == high+1){
                nums[k] = temp[i++];
            }else if (temp[i] < temp[j]){
                nums[k] = temp[i++];
            }
            else {
                nums[k] = temp[j++];
            }
        }


    }

}
