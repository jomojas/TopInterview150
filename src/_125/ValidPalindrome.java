package _125;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "asasasasasa";
        System.out.println(solution.isPalindrome(str)); // true
    }
}

/* My method */
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

/* Solution */
// class Solution {
//     public boolean isPalindrome(String s) {
//         s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//         int left = 0;
//         int right = s.length() - 1;

//         while (left < right) {
//             if (s.charAt(left) != s.charAt(right)) {
//                 return false;
//             }
//             left++;
//             right--;
//         }
//         return true;        
//     }
// }