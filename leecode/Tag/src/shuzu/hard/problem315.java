/** 计算右侧小于当前元素的个数
 *  给你一个整数数组nums，按要求返回一个新数组counts。
 *  counts[i]的值是 nums[i]右侧小于nums[i]的元素的数量。
 */

package shuzu.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//自己的解法有问题，无法通过全部案例
//public class problem315 {
//
//    public static void main(String[] args) {
//        int[] a = new int[]{2, 0, 1};
//        countSmaller(a);
//    }
//
//    public static List<Integer> countSmaller(int[] nums) {
//        LinkedList<Integer> res = new LinkedList<>();
//        res.addFirst(0);
//        int[] counts = new int[nums.length];
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int count = help(i, nums, counts);
//            counts[i] = count;
//            res.addFirst(count);
//        }
//
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }
//
//        return res;
//    }
//
//    public static int help(int index, int[] nums, int[] counts){
//        int count = 0;
//        if (nums[index] > nums[index+1]){
//            count = 1 + counts[index+1];
//        }else if (nums[index] <= nums[index+1]){
//            int inx = index;
//            while (index < counts.length && nums[inx] <= nums[index]) index++;
//            if (index < counts.length && nums[inx] > nums[index]){
//                count = 1 + counts[index];
//            }
//        }
//        return count;
//    }
//}




public class problem315 {

    private static class Pair{
        int val, id;
        Pair(int val, int id){
            this.val = val;  //保存真正的值
            this.id = id;    //保存在原数组中值对应的索引值
        }
    }

    private static Pair[] temp; //归并排序时用的辅助数组
    private static int[] count; //记录答案的数组，记录每个元素后面比自己小的元素个数

    public static void main(String[] args) {
        int[] a = new int[]{5,2,6,1};
        countSmaller(a);
    }

    public static List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int n = nums.length;
        count = new int[n];   //答案数组初始化，默认值为0
        temp = new Pair[n];   //辅助数组初始化
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);  //创建用来排序的原始数组，将其包装成pair类
        }

//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i].val + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i].id + " ");
//        }
        sort(arr, 0, n - 1);
        for (int i : count) res.add(i);

        return res;
    }

    public static void sort(Pair[] arr, int low, int high){
        if (low==high) return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(Pair[] arr, int low, int mid, int high){
        for (int i = low; i <= high; i++) {  //先把要排序的元素复制到辅助数组中
            temp[i] = arr[i];
        }

        int i = low, j=mid+1;
        for (int k = low; k <= high; k++) {
            if (i == mid+1){   //左边已经添加完了，把右边剩下的添加进去
                arr[k] = temp[j++];
            }else if (j == high+1){ //把左边没有添加完的添加进去
                arr[k] = temp[i++];
                count[arr[k].id] += j - mid - 1;
            }else if (temp[i].val > temp[j].val){
                arr[k] = temp[j++];
            }else {
                arr[k] = temp[i++];
                count[arr[k].id] += j - mid - 1;
            }
        }


    }

}
