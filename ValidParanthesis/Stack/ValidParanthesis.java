package Stack;

import java.util.Stack;

public class ValidParanthesis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '('
                || currentChar == '['
                || currentChar == '{') {
                stack.push(currentChar);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character top = stack.peek();
                if ((top == '[' && currentChar == ']')
                    || (top == '{' && currentChar == '}')
                    || (top == '(' && currentChar == ')')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({})"));
    }
}
