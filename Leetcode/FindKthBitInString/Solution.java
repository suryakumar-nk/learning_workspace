package Leetcode.FindKthBitInString;

public class Solution {
    public static void main(String[] args) {
        int n=3, k=1;
        String s = "0";
        int i = 1;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c == '1' ? '0' : '1');
            }
            s = s + "1" + sb.reverse().toString();
            i++;
        }
        System.out.println(s.charAt(k));
    }
}