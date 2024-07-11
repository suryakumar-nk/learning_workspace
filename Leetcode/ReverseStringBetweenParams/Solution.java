package ReverseStringBetweenParams;

import java.util.Stack;

public class Solution {
    
    private String reverseString(String s) {
        String reversedStr = "";
        for (int i = 0; i < s.length(); i++) {
            reversedStr = s.charAt(i) + reversedStr;
        }
        return reversedStr;
    }

    public String reverseParentheses(String s) {
        int n = s.length();
        var params = new Stack<Integer>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '(') {
                params.add(i++);
            }
            else if (s.charAt(i) == ')') {
                int start = params.pop();
                s = s.substring(0, start) + reverseString(s.substring(start+1, i)) + s.substring(i+1);
                n = s.length();
                i--;
            } else {
                i++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.reverseParentheses("(ed(et(oc))el)"));
    }
}
