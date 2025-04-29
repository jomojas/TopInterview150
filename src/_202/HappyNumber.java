package _202;

// import java.util.*;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 19; // Example number to check
        System.out.println(solution.isHappy(n)); // Output: true
    }
}

/* My method */
class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        String str = String.valueOf(n);
        int resNum = 0;
        for(int i = 0; i < 7; i++) {
            for(char c : str.toCharArray()) {
                int num = c - '0';
                resNum += num * num;
            }
            if(resNum == 1) return true;
            str = String.valueOf(resNum);
            resNum = 0;
        }
        return false;
    }
}

/* Solution (Using HashSet) */
// class Solution {
//     public boolean isHappy(int n) {
//         Set<Integer> set = new HashSet<>();
//         while(!set.contains(n)) {
//             set.add(n);
//             n = square(n);
//             if(n == 1) return true;
//         }
//         return false;
//     }

//     private int square(int n) {
//         int output = 0;  
//         while(n > 0) {
//             int digit = n % 10;
//             output += digit * digit;
//             n = n / 10;
//         }
//         return output;
//     }
// }

/* Solution (Using slow fast pointers) */
// class Solution {
//     public boolean isHappy(int n) {
//         int slow = square(n);
//         int fast = square(square(n));   // 1 produces 1

//         while(slow != fast) {
//             if(fast == 1) return true;
//             slow = square(slow);
//             fast = square(square(fast));
//         }        
//         return slow == 1;   // when n == 1, 10, 100, etc
//     }

//     private int square(int n) {
//         int output = 0;  
//         while(n > 0) {
//             int digit = n % 10;
//             output += digit * digit;
//             n = n / 10;
//         }
//         return output;
//     }
// }