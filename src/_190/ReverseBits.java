package _190;

public class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(43261596)); // 964176192
        System.out.println(solution.reverseBits(-3)); // -1073741825
    }
}

/* My stupid method */
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder inputString = new StringBuilder();
        int m = n >= 0 ? n : n * (-1);
        for(int i = 0; i < 32; i++) {
            if(m == 1) {
                inputString.append(m);
                m = 0;
                continue;
            }
            if(m == 0) {
                inputString.append(0);
                continue;
            }
            if(m % 2 == 0) {
                inputString.append(0);
                m = m / 2;
            } else if(m % 2 == 1) {
                inputString.append(1);
                m = m / 2;
            }
        }
        inputString.reverse();
        if(n < 0) {
            for(int i = 0; i < inputString.length(); i++) {
                inputString.setCharAt(i, (inputString.charAt(i) == '0') ? '1' : '0');
            }
            int carry = 1;
            for(int j = inputString.length() - 1; j != 0; j--) {
                if((inputString.charAt(j) - '0') + carry == 1) {
                    inputString.setCharAt(j, '1');
                    break;
                } else {
                    inputString.setCharAt(j, '0');
                }
            }
        }
        String input = inputString.toString();
        int ans = 0;
        for(int j = input.length() - 1; j != -1; j--) {
            if(j == input.length() - 1) {
                ans -= Math.pow(2, j) * (input.charAt(j) - '0');
            } else {
                ans += Math.pow(2, j) * (input.charAt(j) - '0');
            }
        }
        return ans;
    }
}

/* Solution (Bits manipulation) */
// class Solution {
//     public int reverseBits(int n) {
//         int result = 0;

//         for(int i = 0; i < 32; i++){
//             result <<= 1;
//             if((n & 1) == 1) result++;
//             n >>= 1;
//         }
//         return result;
//     }
// } 