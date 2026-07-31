package Problem560_SubarraySumEqualsK;

import java.util.HashMap;

public class SubarraySumEqualsK {
    /**
     * Returns the number of continuous subarrays whose sum equals k.
     * Uses prefix-sum + HashMap counting technique.
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // zero prefix sum occurs once

        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            // if (sum - k) seen before, add how many times it occurred
            if (prefixCount.containsKey(sum - k)) {
                count += prefixCount.get(sum - k);
            }
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // quick local tests
    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums1 = {1, 1, 1};
        System.out.println(solution.subarraySum(nums1, 2)); // expected 2

        int[] nums2 = {1, 2, 3};
        System.out.println(solution.subarraySum(nums2, 3)); // expected 2 ( [1,2], [3] )

        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(solution.subarraySum(nums3, 7)); // you can verify expected output manually
    }
}

