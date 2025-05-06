package _69;

public class SqrtX {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4)); // Output: 2
        System.out.println(solution.mySqrt(8)); // Output: 2
    }
}

/* My stupid method */
// class Solution {
//     public int mySqrt(int x) {
//         int y = 0;
//         while(true) {
//             if((long)y * y <= x && (long)(y + 1) * (y + 1) > x) {
//                 break;
//             }
//             y++;
//         }
//         return y;
//     }
// }

/* My method (hinted) */
class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = (int)Integer.MAX_VALUE / 100;   // The right could be x rather than Integer.MAX_VALUE.
        int mid = 0;
        while(true) {
            mid = left + (right - left) / 2;
            if((long)mid * mid <= x && (long)(mid + 1) * (mid + 1) > x) {
                break;
            }
            if((long)mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return mid;
    }
}

/* Solution */
// class Solution {
//     public int mySqrt(int x) {
//         if (x == 0) return 0;

//         int low = 1, high = x;
//         while (low <= high) {
//             long mid = low + (high - low) / 2;
//             long val = mid * mid;
//             if (val <= x) {
//                 low = (int) mid + 1;
//             } else {
//                 high = (int) mid - 1;
//             }
//         }
//         return high;
//     }
// }