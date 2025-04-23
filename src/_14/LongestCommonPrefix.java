package _14;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs)); // Output: "fl"
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        /* My method */
        int smallestLength = strs[0].length();
        for (int i = 0; i != strs.length; i++) {
            smallestLength = (smallestLength <= strs[i].length()) ? smallestLength : strs[i].length();
        }
        if (smallestLength == 0) {
            return "";
        }
        String prefix = "";
        boolean over = false;
        int j = 0;
        for (; j != smallestLength; j++) {
            char commonChar = strs[0].charAt(j);
            for (int k = 0; k != strs.length / 2 + 1; k++) {
                if (strs[k].charAt(j) != commonChar || strs[strs.length - 1 - k].charAt(j) != commonChar) {
                    over = true;
                    break;
                }       
            }
            if (over) {
                break;
            }
        }
        prefix = strs[0].substring(0, j);
        return prefix;


        /* Solution */
        // if (strs == null || strs.length == 0) return "";
        // String prefix = strs[0];
        // for (int i = 1; i < strs.length; i++) {
        //     while (!strs[i].startsWith(prefix)) {
        //         prefix = prefix.substring(0, prefix.length() - 1);
        //         if (prefix.isEmpty()) return "";
        //     }
        // }
        // return prefix;
    }
}