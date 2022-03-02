/** 盛最多水的容器
 *  给定一个长度为n的整数数组height。
 *  有n条垂线，第i条线的两个端点是(i,0)和(i,height[i])
 *  找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *  返回容器可以存储的最大水量
 */

package shuzu.middle;

public class problem11 {

    public static void main(String[] args) {
        int[] a = new int[]{1,8};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {
//        int len = height.length;
//        int maxVolumn = -1;
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1; j < len; j++) {
//                int h = height[i] > height[j] ? height[j] :height[i];
//                int temp = (j-i) * h;
//                if (temp > maxVolumn){
//                    maxVolumn = temp;
//                }
//            }
//        }


        int left = 0;
        int right = height.length - 1;
        int maxVolumn = -1;

        while (left < right){
            if (height[left] > height[right]){
                if ((right - left) * height[right] > maxVolumn)
                    maxVolumn = (right - left) * height[right];
                right--;
            }
            else if (height[left] <= height[right]){

                if ((right - left) * height[left] > maxVolumn)
                    maxVolumn = (right - left) * height[left];
                left++;
            }

        }

        return maxVolumn;
    }



}
