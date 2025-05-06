package _191;

public class Numberof1Bits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(0b00000000000000000000000000001011)); // 3
        System.out.println(solution.hammingWeight(0b00000000000000000000000010000000)); // 1
    }
}

/* My method */
class Solution {
    public int hammingWeight(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) res++;
            n >>= 1;
            // The above two lines can be replaced with the following line:
            // if (((n >> i) & 1) == 1) {
            //     res += 1;
            // }
        }
        return res;
    }
}

/* Solution */
// class Solution {
//     public int hammingWeight(int n) {
//         int count = 0;
//         while(n != 0) {
//             n &= n - 1;
//             count++;
//         }
//         return count;
//     }
// }