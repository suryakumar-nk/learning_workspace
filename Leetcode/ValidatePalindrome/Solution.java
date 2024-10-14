package Leetcode.ValidatePalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
        	char f = s.charAt(i);
        	char l = s.charAt(j);
        	if (!Character.isLetterOrDigit(f)) {
        		i++;
        	} else if(!Character.isLetterOrDigit(l)) {
        		j--;
        	} else {
        		if (Character.toLowerCase(f) != Character.toLowerCase(l)) {
        			return false;
        		}
        		i++;
        		j--;
        	}
        }
        return true;
    }

    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a > 5);
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'9');
        String s = "0p";
        System.out.println(new Solution().isPalindrome(s));
        int n = s.length();
        int i=0, j=n-1;
        while (i <= j) {
            char f = s.charAt(i);
            char l = s.charAt(j);
            if (!(f >= 65 && f <= 90) && !(f >= 97 && f <= 122)) {
                i++;
                continue;
            }
            if (!(l >= 65 && l <= 90) && !(l >= 97 && l <= 122)) {
                j--;
                continue;
            }
            if (f >= 65 && f <= 90) {
                f = (char)(f + 32);
            }
            if (l >= 65 && l <= 90) {
                l = (char)(l + 32);
            }
            if (l != f) {
                System.out.println(false);
                break;
            }
            i++;
            j--;
        }
        System.out.println(true);
    }
}