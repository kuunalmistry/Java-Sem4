package Problem503_NextGreaterElementII;

import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII nge = new NextGreaterElementII();
        int[] nums = {1, 2, 1};
        int[] result = nge.nextGreaterElements(nums);
        for (int r : result) {
            System.out.print(r + " ");
        }
        // Output: 2 -1 2
    }
}
