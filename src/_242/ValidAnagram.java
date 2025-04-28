package _242;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }
}

/* My method 1 */
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;
//         Map<Character, Integer> map = new HashMap<>();
//         // for (int i = 0; i < s.length(); i++) {
//         //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//         // }
//         // for (int j = 0; j < t.length(); j++) {
//         //     if (map.containsKey(t.charAt(j)) && map.get(t.charAt(j)) != 0) {
//         //         map.put(t.charAt(j), map.get(t.charAt(j)) - 1);
//         //     } else {
//         //         return false;
//         //     }
//         // }

//         for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         for (char c : t.toCharArray()) {
//             if (map.containsKey(c) && map.get(c) != 0) {
//                 map.put(c, map.get(c) - 1);
//             } else {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

/* My method 2 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (mapT.containsKey(s.charAt(i))) {
                    mapT.put(s.charAt(i), mapT.get(s.charAt(i)) - 1);
                } else {
                    mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
                }

                if (mapS.containsKey(t.charAt(i))) {
                    mapS.put(t.charAt(i), mapS.get(t.charAt(i)) - 1);
                } else {
                    mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
                }
            } 
        }
        for (Integer value : mapS.values()) {
            if (value != 0) {
                return false;
            }
        }
        for (Integer value : mapT.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}

/* Solution */
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }

//         int[] count = new int[26];

//         for (int i = 0; i < s.length(); i++) {
//             count[s.charAt(i) - 'a'] += 1;
//         }

//         for (int i = 0; i < t.length(); i++) {
//             if (count[t.charAt(i) - 'a'] == 0) {
//                 return false;
//             }
//             count[t.charAt(i) - 'a'] -= 1;
//         }

//         return true;        
//     }
// }