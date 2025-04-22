package _58;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Hello World";
        System.out.println(solution.lengthOfLastWord(s)); // Output: 5
    }
}

class Solution {
    /* My method */
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i != -1; i--) {
            if (s.charAt(i) == ' ' && length != 0) {
                break;
            }
            if (s.charAt(i) == ' ') {
                continue;
            } else {
                length++;
            }
        }
        return length;
    }

    /* Solution 1 */
    // public int lengthOfLastWord(String s) {
    //     int ans = 0;

    //     for(int i = s.length() - 1; i >= 0; i--){
    //         if(s.charAt(i) == ' ' && ans > 0) break;
    //         else if(s.charAt(i) != ' ') ans++;
    //     }
    //     return ans;
    // }

    /* Solution 2 */
    // public int lengthOfLastWord(String s) {
    //     int end = s.length() - 1;

    //     while (end >= 0 && s.charAt(end) == ' ') {
    //         end--;
    //     }

    //     int start = end;
    //     while (start >= 0 && s.charAt(start) != ' ') {
    //         start--;
    //     }

    //     return end - start;        
    // }
}