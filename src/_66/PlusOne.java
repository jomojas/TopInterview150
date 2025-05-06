package _66;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        int[] digits = {9, 9, 9};
        int[] result = solution.plusOne(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}

/* My method (redundant) */
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits[len - 1] < 9) {
            digits[len - 1] += 1;
            return digits;
        }
        int[] res = new int[len + 1];
        for(int i = len - 1; i >= 0; i--) {
            if(digits[i] + 1 == 10) {
                digits[i] = 0;
                res[i + 1] = digits[i];
                if(i == 0) {
                    res[i] = 1;
                    return res;
                }
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        return digits;
    }
}

/* Solution (concise) (handle normal cases first, special cases later) */
// class Solution {
//     public int[] plusOne(int[] digits) {
//         int len = digits.length;
        
//         for (int i = len - 1; i >= 0; i--) {
//             if (digits[i] < 9) {
//                 digits[i]++;
//                 return digits;
//             }
//             digits[i] = 0; // set to 0 and continue to carry over
//         }
        
//         // If all digits were 9 (e.g., 999), we need a new array like 1000
//         int[] res = new int[len + 1];
//         // The first digit is 1, the rest are already set to 0 (by default)
//         res[0] = 1;
//         return res;
//     }
// }