package Leetcode.IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String s = "egg", t="add";
        int n=s.length();
        boolean flag = true;
        Map<Character, Character> forwardMap = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            if (forwardMap.get(s.charAt(i)) == null) {
                forwardMap.put(s.charAt(i), t.charAt(i));
            }
            if (reverseMap.get(t.charAt(i)) == null) {
                reverseMap.put(t.charAt(i), s.charAt(i));
            }
            if (forwardMap.get(s.charAt(i)) != t.charAt(i)) {
                flag = false;
                break;
            }
            if (reverseMap.get(t.charAt(i)) != s.charAt(i)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}