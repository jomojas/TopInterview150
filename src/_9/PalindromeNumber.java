package _9;

// import java.util.ArrayList;
// import java.util.List;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121)); // true
        System.out.println(solution.isPalindrome(-121)); // false
        System.out.println(solution.isPalindrome(10)); // false
        System.out.println(solution.isPalindrome(12321)); // true
    }
}
 
/* My method (Convert x to String) */
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String number = String.valueOf(x);
        int i = 0;
        int j = number.length() - 1;
        while(i <= j) {
            if(number.charAt(i) != number.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

/* My method (Get single digit with modulo, storing digits in array) */
// class Solution {
//     public boolean isPalindrome(int x) {
//         if(x < 0) return false;
//         List<Integer> number = new ArrayList<>();
//         while(x != 0) {
//             number.add(x % 10);
//             x /= 10;
//         }
//         for(int i = 0, j = number.size() - 1; i <= j; i++, j--){
//             if(number.get(i) != number.get(j)) return false; 
//         }
//         return true;
//     }
// }

/* Solution (reverse x with modulo) */
// class Solution {
//     public boolean isPalindrome(int x) {
//         if(x < 0) return false;

//         int y = x;
//         int reverse = 0;
//         while(x != 0) {
//             reverse = (reverse * 10) + x % 10;
//             x /= 10;
//         }
//         return y == reverse;
//     }
// }