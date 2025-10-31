package sort;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 8, 10, 1, 2, 1};
        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(arr, left, right);
        sort(arr, left, pivotIndex - 1);
        sort(arr, pivotIndex + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
