package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return true;
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b) return false;
            } else if (map.containsValue(b)) {
                return false;
            } else {
                map.put(a, b);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));      // true
        System.out.println(isIsomorphic("foo", "bar"));      // false
        System.out.println(isIsomorphic("paper", "title"));  // true
    }
}