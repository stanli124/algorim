/** 滑动窗口最大值
 *  给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 *  你只可以看到滑动窗口内的k个数字.滑动窗口每次只向右移动一位。
 *  返回滑动窗口中的最大值。
 */

package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class problem239 {

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{7,2, 4}, 2));
    }

//    public static int[] maxSlidingWindow(int[] nums, int k) {
////        int len = nums.length;
////        if (len == 1) return nums;
////
////        int[] res = new int[len - k + 1];
////
////        int max = Integer.MIN_VALUE;
////        for (int i = 0; i < len - k + 1; i++) {
////            for (int j = i; j < i+k; j++) {
////                if (nums[j] > max) max = nums[j];
////            }
////            res[i] = max;
////        }
////        for (int i = 0; i < res.length; i++) {
////            System.out.println(res[i]);
////        }
////        return res;
//
//        int len = nums.length;
//        if (len == 1) return nums;
//
//        int[] res = new int[len - k + 1];
//
//        int max = Integer.MIN_VALUE;
//        int index = -1;
//        for (int i = 0; i < k; i++) {
//            if (nums[i] > max) {
//                max = nums[i];
//                index = i;
//            }
//        }
//        res[0] = max;
//
//
//        for (int i = 1; i < len - k + 1; i++) {
//            if (index >= i){
//                if (i+k-1 <= len - k + 1 && nums[i+k-1] > max){
//                    max = nums[i+k-1];
//                    res[i] = nums[i+k-1];
//                    index = i+k-1;
//                }else
//                    res[i] = max;
//            }else{
//                for (int j = i; j < i+k; j++) {
//                    if (nums[j] > max) {
//                        max = nums[j];
//                        index = j;
//                    }
//                }
//                res[i]=max;
//            }
//        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i]);
//        }
//        return res;
//    }


//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int len  = nums.length;
//        if (len == 1 || k==1) return nums;
//        int[] res = new int[len - k + 1];
//        Deque<Integer> deque = new LinkedList<>(); //双端队列
//
//        for (int i = 0; i < k; i++) {
//            if (deque.isEmpty()) deque.push(nums[i]);
//            else {
//                if (nums[i] >= deque.peekLast()){
//                    while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
//                        deque.pollLast();
//                    }
//                    deque.offerLast(nums[i]);
//                }else {
//                    deque.offerLast(nums[i]);
//                }
//            }
//        }
//        res[0] = deque.pollFirst();
//
//        for (int i = 1; i+k-1 < len; i++) {
//            if (deque.isEmpty()) deque.push(nums[i+k-1]);
//            else {
//                if (nums[i+k-1] > deque.peekLast()){
//                    while (!deque.isEmpty() && nums[i+k-1] > deque.peekLast()) {
//                        deque.pollLast();
//                    }
//                    deque.offerLast(nums[i+k-1]);
//                }
//                res[i] = deque.pollFirst();
//            }
//        }
//
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i]);
//        }
//
//        return res;
//    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
//
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i]);
//        }

        return res;
    }

}
