package _28;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "sasbutsad";
        String needle = "sad";
        System.out.println(solution.strStr(haystack, needle));
    }
}

// /* KMP algorithm */
class Solution {
    public int strStr(String haystack, String needle) {
        int[] LPS = getLPS(needle);
        int i = 0;
        int j = 0;
        while (i != haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = LPS[j - 1];
                }
            }
        }
        return -1;
    }

    public int[] getLPS(String pattern) {
        int[] lpsArray = new int[pattern.length()];
        lpsArray[0] = 0;
        int length = 0;
        int i = 1;
        while (i != pattern.length()) {
            if (pattern.charAt(length) == pattern.charAt(i)) {
                length++;
                lpsArray[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lpsArray[length - 1];
                } else {
                    i++;
                }
            }
        }
        return lpsArray;
    }
}

/* Solution */
// class Solution {
//     public int strStr(String haystack, String needle) {
//         if (haystack.length() < needle.length()) {
//             return -1;
//         }
        
//         for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//             if (haystack.substring(i, i + needle.length()).equals(needle)) {
//                 return i;
//             }
//         }
        
//         return -1;        
//     }
// }