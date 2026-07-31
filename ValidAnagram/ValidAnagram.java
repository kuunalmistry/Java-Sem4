public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() == 1 && t.length() == 1) {
            return s.charAt(0) == t.charAt(0);
        }
        if (s.length() != t.length()) {
            return false; // If lengths differ, they cannot be anagrams
        }

        int[] occurrence = new int[26]; // Assuming only lowercase letters a-z

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            occurrence[c - 'a']++; // Increment count for character in s
        }

        for (char c : t.toCharArray()) {
            if (occurrence[c - 'a'] == 0) {
                return false;
            }
            occurrence[c - 'a']--; // Decrement count for character in t
        }

        return true; // If all counts are zero, they are anagrams
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println("Are the strings anagrams? " + result); // Output should be true
    }
}
