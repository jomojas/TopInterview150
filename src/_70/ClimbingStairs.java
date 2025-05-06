package _70;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(35)); // Output: 14930352
    }
}

/* My method (Modified by Chatgpt) */
// class Solution {
//     public int climbStairs(int n) {
//         int count = 0;
//         long cases = 0;
//         for(int i = 1; i <= n - 2; i++) {
//             if((n - i) % 2 == 0) {
//                 cases = comb(i + (n - i) / 2, i);
//                 count += cases;
//             }
//         }
//         if(n % 2 == 0) {
//             return count + 2;
//         } else {
//             return count + 1;
//         }
//     }

//     private long comb(int n, int k) {
//         long res = 1;
//         for(int i = 1; i <= k; i++) {
//             res = res * (n - i + 1) / i;
//         }
//         return res;
//     }
// }


/* Solution */
class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;

        int prev1 = 3;
        int prev2 = 2;
        int cur = 0;

        /*
         * cur = prev1 + prev2
         * To reach the current step, you can either:
         * Take a single step from the previous step (prev1), or
         * Take a double step from the step before the previous step (prev2).
         */
        for (int i = 3; i < n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;        
    }
}