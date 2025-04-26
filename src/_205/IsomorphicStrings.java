package _205;

import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egg", "add")); // true
        System.out.println(solution.isIsomorphic("foo", "bar")); // false
        System.out.println(solution.isIsomorphic("paper", "title")); // true
        System.out.println(solution.isIsomorphic("badc", "baba")); // false
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        /* My method */
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i)) && map1.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            } 
            map1.put(s.charAt(i), t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (map2.containsKey(t.charAt(i)) && map2.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            } 
            map2.put(t.charAt(i), s.charAt(i));
        }
        return true;

        /* Solution (Same thought) */
        // HashMap<Character, Character> charMap = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char sc = s.charAt(i);
        //     char tc = t.charAt(i);

        //     if (charMap.containsKey(sc)) {
        //         if (charMap.get(sc) != tc) {
        //             return false;
        //         }
        //     } else if (charMap.containsValue(tc)) {
        //         return false;
        //     }

        //     charMap.put(sc, tc);
        // }
        // return true;  

        /* Solution */
        // HashMap<Character, Integer> charIndexS = new HashMap<>();
        // HashMap<Character, Integer> charIndexT = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     if (!charIndexS.containsKey(s.charAt(i))) {
        //         charIndexS.put(s.charAt(i), i);
        //     }

        //     if (!charIndexT.containsKey(t.charAt(i))) {
        //         charIndexT.put(t.charAt(i), i);
        //     }

        //     if (!charIndexS.get(s.charAt(i)).equals(charIndexT.get(t.charAt(i)))) {
        //         return false;
        //     }
        // }

        // return true;        
    }
}