package Leetcode.MinumumAddToMakeParanthesisValid;

public class Solution {

    public int otherMethod(String s) {
        int open = 0;
        int close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        return open+close;
    }
    public static void main(String[] args) {
        String s = "((()()))()()(()()()())(((())()()()()()()()()())))()()(()))()))(((()()";
        // s = "))))((("
        int i=0, n = s.length();
        int j = 0;
        System.out.println("ans: "+new Solution().otherMethod(s));
        System.out.println(n);
        while (i<n) {
            j++;
            if (s.charAt(i) == '(' && i<(n-1) && s.charAt(i+1) == ')') {
                s = s.substring(0, i) + s.substring(i+2, n);
                n-=2;
                continue;
            }
            if (s.charAt(i) == ')' && i>0 && s.charAt(i-1) == '(') {
                s = s.substring(0, i-1) + s.substring(i+1, n);
                n-=2;
                i-=1;
                continue;
            }
            i++;
        }
        System.out.println("ans: "+ s.length());
        System.out.println(j);
    }
}
