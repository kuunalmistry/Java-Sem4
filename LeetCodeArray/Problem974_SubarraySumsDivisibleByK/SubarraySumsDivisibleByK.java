package Problem974_SubarraySumsDivisibleByK;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // remainder 0 initially appears once

        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            int remainder = sum % k;

            // handle negative remainders
            if (remainder < 0) {
                remainder += k;
            }

            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumsDivisibleByK solution = new SubarraySumsDivisibleByK();

        int[] nums1 = {4,5,0,-2,-3,1};
        System.out.println(solution.subarraysDivByK(nums1, 5)); // expected 7

        int[] nums2 = {5};
        System.out.println(solution.subarraysDivByK(nums2, 9)); // expected 0
    }
}
