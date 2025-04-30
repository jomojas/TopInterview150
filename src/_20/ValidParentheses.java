package _20;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "([{}])";
        System.out.println(solution.isValid(s)); // Output: true
    }
}

/* My method */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char top = stack.peek();
                char currentChar = s.charAt(i);
                if((currentChar == ')' && top == '(')
                || (currentChar == ']' && top == '[') 
                || (currentChar == '}' && top == '{')) {
                    stack.pop();
                } else {
                    stack.push(currentChar);
                }
            }
        }
        return stack.isEmpty();
    }
}

/* Solution */
// class Solution {
//     public boolean isValid(String s) {
//         int n = s.length();
//         if (n % 2 == 1)return false;
//         char[] stack = new char[n];
//         int top = -1;
//         for (char c : s.toCharArray()) {
//             if (c == '(')stack[++top] = ')';
//             else if (c == '{')stack[++top] = '}';
//             else if (c == '[')stack[++top] = ']';
//             else if(top == -1 || stack[top--] != c)return false;
//         }
//         return top == -1;
//     }
// }