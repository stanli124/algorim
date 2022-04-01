package Stack_Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class problem480 {
    public static void main(String[] args) {
        medianSlidingWindow(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}, 3);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length-k+1];
        PriorityQueue<Double> queue = new PriorityQueue(k);
//错误做法
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i]);
//
//            queue.add(Double.valueOf(nums[i]));
//            if (i-k+1>=0){
//                if (k%2==0){
//                    for (int j = 0; j < k/2-1; j++) {
//                        queue.poll();
//                    }
//                    double num1 = queue.peek();
//
//                }else {
//                    queue.poll();
//                    res[i-k+1] = queue.peek();
//                }
//            }
//        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i]+" ");
//        }
//        return res;
        if (k==1){
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i];
            }
            return res;
        }
        for (int i = k-1; i < nums.length; i++) {
            int[] subNums = new int[k];
            for (int j = 0, sublen=i; j < k; j++,sublen--) {
                subNums[j] = nums[sublen];
            }
            double median = medianNum(subNums, k);
            res[i-k+1] = median;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
        return res;
    }

    public static double medianNum(int[] subNums, int k){
        Arrays.sort(subNums);
        double res = -1;
        if (k%2==0){
            double num1 = subNums[k/2-1];
            double num2 = subNums[k/2];
            res = (num1+num2) / 2.0;
        }else{
            res = subNums[k/2];
        }
        return res;
    }

}
