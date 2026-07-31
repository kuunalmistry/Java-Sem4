package Problem11_ContainerWithMostWater;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();

        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = obj.maxArea(height);

        System.out.println("Maximum Container Area: " + result);
    }
}
