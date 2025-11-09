public class ContainerMostWater {
    public static void main(String[] args) {

    }
}

class CSolution2 {
    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int curArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(curArea, maxArea);
            }
        }

        return maxArea;
    }

    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(curArea, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
