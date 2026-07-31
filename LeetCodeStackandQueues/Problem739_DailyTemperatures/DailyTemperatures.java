package Problem739_DailyTemperatures;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dt.dailyTemperatures(arr);
        for (int r : result) {
            System.out.print(r + " ");
        }
        // Output: 1 1 4 2 1 1 0 0
    }
}
