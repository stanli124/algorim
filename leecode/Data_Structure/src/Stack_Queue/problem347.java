/** 前k个高频元素
 *  给你一个整数数组 nums 和 一个整数k。
 *  请你返回其中出现频率前k高的元素。
 */

package Stack_Queue;

import java.util.*;

public class problem347 {

    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] a = new int[k];

        PriorityQueue<Integer> res = new PriorityQueue<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            a[i] = queue.poll().getKey();
        }
        return a;
    }

}
