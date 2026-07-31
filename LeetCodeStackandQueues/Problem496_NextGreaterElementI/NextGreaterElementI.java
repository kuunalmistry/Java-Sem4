package Problem496_NextGreaterElementI;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Build map of next greater elements for nums2
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Fill result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementI solution = new NextGreaterElementI();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res1 = solution.nextGreaterElement(nums1, nums2);
        for (int n : res1) System.out.print(n + " "); // expected -1 3 -1
        System.out.println();

        int[] nums3 = {2, 4};
        int[] nums4 = {1, 2, 3, 4};
        int[] res2 = solution.nextGreaterElement(nums3, nums4);
        for (int n : res2) System.out.print(n + " "); // expected 3 -1
    }
}
