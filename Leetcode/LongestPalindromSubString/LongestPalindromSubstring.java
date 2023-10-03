package LongestPalindromSubString;

public class LongestPalindromSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<n-i; j++) {
                String str = s.substring(j, i+j+1);
                if (palindrom(str)) return str;
            }
        }
        return "";
    }
    
    private boolean palindrom(String str) {
        int n = str.length();
        for (int i=0; i<n/2; i++) {
            if (str.charAt(i) == str.charAt(n-i-1)) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromSubstring().longestPalindrome("ftoof"));
    }
}
