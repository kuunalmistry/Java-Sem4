package Problem394_DecodeString;

import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // build multiplier
            } else if (c == '[') {
                counts.push(k);
                resultStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeatTimes = counts.pop();
                StringBuilder decoded = resultStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        DecodeString solver = new DecodeString();
        String s = "3[a2[c]]";
        System.out.println(solver.decodeString(s));
        // Expected Output: "accaccacc"
    }
}
