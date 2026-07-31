package Problem1003_CheckIfWordIsValidAfterSubstitutions;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions {

    public static boolean isValid(String s) {
        if (s.length() % 3 != 0) {
            return false;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'c') {
                if (st.size() < 2 || st.pop() != 'b' || st.pop() != 'a') {
                    return false;
                }
            } else {
                st.push(ch);
            }
        }

        return st.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabcbc"));       
        System.out.println(isValid("abcabcababcc"));  
        System.out.println(isValid("abccba"));        
    }
}

