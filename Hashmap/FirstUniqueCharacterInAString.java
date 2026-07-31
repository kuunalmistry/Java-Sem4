package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static int firstUnique(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) + 1);
            } else {
                freq.put(ch, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println("First unique index in \"" + s1 + "\": " + firstUnique(s1));
        System.out.println("First unique index in \"" + s2 + "\": " + firstUnique(s2));
        System.out.println("First unique index in \"" + s3 + "\": " + firstUnique(s3));
    }
}
