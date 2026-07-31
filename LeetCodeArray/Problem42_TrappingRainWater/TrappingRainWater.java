package Problem42_TrappingRainWater;

public class TrappingRainWater {

    // Function to calculate trapped rain water
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = obj.trap(height);

        System.out.println("Trapped Rain Water: " + result);
    }
}
