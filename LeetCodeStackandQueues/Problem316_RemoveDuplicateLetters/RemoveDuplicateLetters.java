package Problem316_RemoveDuplicateLetters;

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];  // last occurrence of each char
        boolean[] seen = new boolean[26]; // whether char is in stack

        // Store last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (seen[c - 'a']) continue; // skip if already in stack

            // Maintain lexicographic order
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters solver = new RemoveDuplicateLetters();
        String s = "cbacdcbc";
        System.out.println(solver.removeDuplicateLetters(s)); 
        // Expected Output: "acdb"
    }
}
