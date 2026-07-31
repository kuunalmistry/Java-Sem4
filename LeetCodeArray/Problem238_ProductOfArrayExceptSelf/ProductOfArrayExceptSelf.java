package Problem238_ProductOfArrayExceptSelf;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // Function to calculate product of array except self
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Calculate prefix product
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Multiply by suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix;
            suffix *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();

        int[] nums = {1,2,3,4};
        int[] result = obj.productExceptSelf(nums);

        System.out.println("Output: " + Arrays.toString(result));
    }
}
