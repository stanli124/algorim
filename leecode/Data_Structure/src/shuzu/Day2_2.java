/**   合并两个有序数组
 * 给你两个按 非递减顺序（可能是升序也可能不是升序） 排列的整数数组nums1 和 nums2，另有两个整数 m和n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 */


package shuzu;

import java.util.Arrays;

public class Day2_2 {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0}; //nums1的长度为m+n，是为了保存数组nums2中的n个数字
        int m = 3;
        int[] nums2 = {2, 5,6};
        int n = 3;

        merge(nums1,m,nums2,n);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        //每次按顺序取两个数组中 索引相同的两个值进行比较，小的再前，大的再后插入；
//        int[] mergeArray = new int[m+n];
//        int i=0;
//        int j=0;
//        int idx=0;
//
//        while (i<m && j<n){   //如果有一个数组已经取完值了，则直接把另外一个数组剩下的值复制到数组中；
//            if (nums1[i] <= nums2[j]) {mergeArray[idx]=nums1[i++];}  //把小的放到数组中
//            else {mergeArray[idx]=nums2[j++];}
//            idx++;
//        }
//
//
//        if (i > m-1){ //若nums1取完了，就把nums2剩下的复制到数组中；
//            for ( ;j < n; j++){
//                mergeArray[idx] = nums2[j];
//                idx++;
//            }
//        }
//        else{   //nums2取完了，把nums1剩下的复制到数组中；
//            for ( ; i < m; i++){
//                mergeArray[idx] = nums1[i];
//                idx++;
//            }
//        }
//
//        //只能使用一个循环赋值，如果采用nums1 = mergeArray这种方式，那么会改变nums1指向的数组，导致结果不对；
//        for (int k = 0; k < m+n; k++) {
//            nums1[k] = mergeArray[k];
//        }
//
//        for (int s: nums1) System.out.println(s);


        //先替换nums1中的0，在进行排序
        int idx = 0;
        for (int i = m; i < m+n; i++) {
            nums1[i] = nums2[idx++];
        }
        Arrays.sort(nums1);
        for (int s: nums1) System.out.println(s);
    }

}
