package leetcode;

public class WaterContainer {

    public static void main(String args[]) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area;
            if (height[left] < height[right]) {
                area = (right - left) * height[left];
                left++;
            } else {
                area = (right - left) * height[right];
                right--;
            }
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
