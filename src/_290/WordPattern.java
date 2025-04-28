package _290;

import java.util.*;

public class WordPattern {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern, str));
    }
}

/* My method */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        StringBuilder wordStr = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j == pattern.length())  return false;

            char ScurrentChar = s.charAt(i);

            if (ScurrentChar == ' ') {
                String word = wordStr.toString();
                if (map.containsKey(word)) {
                    if (map.get(word) != pattern.charAt(j)) return false;
                } else if (map.containsValue(pattern.charAt(j))) {
                    return false;
                } else {
                    map.put(word, pattern.charAt(j));
                }

                wordStr.setLength(0);
                j++;
            } else {
                wordStr.append(ScurrentChar);
                if (i == s.length() - 1) {
                    String word = wordStr.toString();

                    if (map.containsKey(word)) {
                        if (map.get(word) != pattern.charAt(j)) return false;
                    } else if (map.containsValue(pattern.charAt(j))) {
                        return false;
                    }
                    j++;
                }
            }
        }
        if (j < pattern.length()) {
            return false;
        }
        return true;
    }
}

/* Solution (same thought using split) */
// class Solution {
//     public boolean wordPattern(String pattern, String s) {
//         String[] sWords = s.split(" ");
//         if(sWords.length != pattern.length()) return false;
//         Map<Character, String> map = new HashMap<>();
 
//         for(int i = 0; i < pattern.length(); i++){
//             char c = pattern.charAt(i);
//             if(map.containsKey(c)){
//                 if(!map.get(c).equals(sWords[i])) return false;
//             }else{
//                 if(map.containsValue(sWords[i])) return false;
//             }
//             map.put(c, sWords[i]);
//         }
//         return true;
//     }
//  }