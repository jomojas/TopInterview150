package _13;

// import java.util.HashMap;
// import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III")); // 3
        System.out.println(solution.romanToInt("IV")); // 4
        System.out.println(solution.romanToInt("IX")); // 9
        System.out.println(solution.romanToInt("LVIII")); // 58
        System.out.println(solution.romanToInt("MCMXCIV")); // 1994
        System.out.println(solution.romanToInt("MCMXC")); // 1990
    }
}

/* My method */
class Solution {
    public int romanToInt(String s) {
        int finalNumber = 0;
        for (int i = 0; i != s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    finalNumber += 1000;
                    break;
                case 'D':
                    finalNumber += 500;
                    break;
                case 'C':
                    if (i != s.length() - 1 && s.charAt(i + 1) == 'D') {   // CD
                        finalNumber += 400;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i + 1) == 'M') { // CM
                        finalNumber += 900;
                        i++;
                    } else {
                        finalNumber += 100;
                    }
                    break;
                case 'L':
                    finalNumber += 50;
                    break;
                case 'X':
                    if (i != s.length() - 1 && s.charAt(i + 1) == 'L') {   // XL
                        finalNumber += 40;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i + 1) == 'C') {    // XC
                        finalNumber += 90;
                        i++;
                    } else {
                        finalNumber += 10;
                    }
                    break;
                case 'V':
                    finalNumber += 5;
                    break;
                case 'I':
                    if (i != s.length() - 1 && s.charAt(i + 1) == 'V') {   // IV
                        finalNumber += 4;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i + 1) == 'X') {    // IX
                        finalNumber += 9;
                        i++;
                    } else {
                        finalNumber += 1;
                    }
                    break;
            }
        }
        return finalNumber;
    }
}

/* Solution */
// class Solution {
//     public int romanToInt(String s) {
//         int res = 0;
//         Map<Character, Integer> roman = new HashMap<>();
//         roman.put('I', 1);
//         roman.put('V', 5);
//         roman.put('X', 10);
//         roman.put('L', 50);
//         roman.put('C', 100);
//         roman.put('D', 500);
//         roman.put('M', 1000);

//         for (int i = 0; i < s.length() - 1; i++) {
//             if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
//                 res -= roman.get(s.charAt(i));
//             } else {
//                 res += roman.get(s.charAt(i));
//             }
//         }

//         return res + roman.get(s.charAt(s.length() - 1));        
//     }
// }