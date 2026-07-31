package Problem53_MaximumSubarray;

public class MaximumSubarray {

    // Function to find maximum subarray sum
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = obj.maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
