package _67;

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "1010";
        String b = "1011";
        System.out.println(solution.addBinary(a, b)); // Output: "11001"
    }
}

/* My method (Single pointer) */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int longLen = lenA > lenB ? lenA : lenB;
        int c = 0;
        for(int i = 0; i < longLen; i++) {
            int sum = 0;
            if(lenA - 1 - i < 0) {
                sum = (b.charAt(lenB - 1 - i) - '0') + c;
                if(sum == 0) {
                    res.append(0);
                    c = 0;
                } else if(sum == 1) {
                    res.append(1);
                    c = 0;
                } else if(sum == 2) {
                    res.append(0);
                    c = 1;
                }
                continue;
            }
            if(lenB - 1 - i < 0) {
                sum = (a.charAt(lenA - 1 - i) - '0') + c;
                if(sum == 0) {
                    res.append(0);
                    c = 0;
                } else if(sum == 1) {
                    res.append(1);
                    c = 0;
                } else if(sum == 2) {
                    res.append(0);
                    c = 1;
                }
                continue;
            }
            sum = (a.charAt(lenA - 1 - i) - '0') + (b.charAt(lenB - 1 - i) - '0') + c;
            if(sum == 0) {
                res.append(0);
                c = 0;
            } else if(sum == 1) {
                res.append(1);
                c = 0;
            } else if(sum == 2) {
                res.append(0);
                c = 1;
            } else if(sum == 3) {
                res.append(1);
                c = 1;
            }
        }
        if(c == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}

/* Solution (two pointers) */
// class Solution 
// {
//   public String addBinary(String a, String b) 
//   {
//     StringBuilder sb = new StringBuilder();
//     int carry = 0;
//     int i = a.length() - 1;
//     int j = b.length() - 1;

//     while (i >= 0 || j >= 0 || carry == 1) 
//     {
//       if(i >= 0)
//         carry += a.charAt(i--) - '0';
//       if(j >= 0)
//         carry += b.charAt(j--) - '0';
//       sb.append(carry % 2);
//       carry /= 2;
//     }
//     return sb.reverse().toString();
//   }
// }