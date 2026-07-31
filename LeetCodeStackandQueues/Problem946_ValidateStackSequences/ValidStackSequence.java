package Problem946_ValidateStackSequences;
import java.util.Stack;

public class ValidStackSequence {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 1) {
            return pushed[0] == popped[0];
        }

        int popIndex = 0;
        Stack<Integer> st = new Stack<>();

        for (int ele : pushed) {
            st.push(ele);
            while (!st.isEmpty() && st.peek() == popped[popIndex]) {
                st.pop();
                popIndex++;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        System.out.println(validateStackSequences(pushed, popped));

        int[] pushed2 = {1, 2, 3, 4, 5};
        int[] popped2 = {4, 3, 5, 1, 2};

        System.out.println(validateStackSequences(pushed2, popped2));
    }
}
