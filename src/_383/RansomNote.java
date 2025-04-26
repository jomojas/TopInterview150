package _383;

import java.util.*;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a", "b")); // false
        System.out.println(solution.canConstruct("aa", "ab")); // false
        System.out.println(solution.canConstruct("aa", "aab")); // true
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        /* My method 1 */
        // Map<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < magazine.length(); i++) {
        //     if (map.containsKey(magazine.charAt(i))) {
        //         map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
        //     }
        //     map.putIfAbsent(magazine.charAt(i), 1);
        // }
        // for (int j = 0; j < ransomNote.length(); j++) {
        //     if (map.containsKey(ransomNote.charAt(j))) {
        //         map.put(ransomNote.charAt(j), map.get(ransomNote.charAt(j)) - 1);
        //         if (map.get(ransomNote.charAt(j)) == 0) {
        //             map.remove(ransomNote.charAt(j));
        //         }
        //     } else {
        //         return false;
        //     }
        // }
        // return true;

        /* My method 2 */
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i != magazine.length() && j != ransomNote.length()) {
            if (ransomNote.charAt(j) == magazine.charAt(i)) {
                i++;
                j++;
            } else {
                if (map.containsKey(ransomNote.charAt(j))) {
                    map.put(ransomNote.charAt(j), map.get(ransomNote.charAt(j)) - 1);
                    if (map.get(ransomNote.charAt(j)) == 0) {
                        map.remove(ransomNote.charAt(j));
                    }
                    j++;
                }
                // if (map.containsKey(magazine.charAt(i))) {
                //     map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
                // } else {
                //     map.put(magazine.charAt(i), 1);
                // }
                map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
                i++;
            }
        }
        for (; j < ransomNote.length(); j++) {
            if (!map.containsKey(ransomNote.charAt(j))) {
                return false;
            }
        }
        return true;

        /* Solution */
        // if (ransomNote.length() > magazine.length()) return false;
        // int[] alphabets_counter = new int[26];
        
        // for (char c : magazine.toCharArray())
        //     alphabets_counter[c-'a']++;

        // for (char c : ransomNote.toCharArray()){
        //     if (alphabets_counter[c-'a'] == 0) return false;
        //     alphabets_counter[c-'a']--;
        // }
        // return true;
    }
}