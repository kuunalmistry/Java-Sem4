package Problem682_BaseballGame;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        
        int total = 0;
        for (int score : stack) {
            total += score;
        }
        return total;
    }

    public static void main(String[] args) {
        BaseballGame solution = new BaseballGame();

        String[] ops1 = {"5","2","C","D","+"};
        System.out.println(solution.calPoints(ops1)); // expected 30

        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        System.out.println(solution.calPoints(ops2)); // expected 27
    }
}
