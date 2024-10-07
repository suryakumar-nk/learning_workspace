package MinimumStringLengthAfterRemovingSubString;

public class Solution {
    public static void main(String[] args) {
        String s = "DABHAOPTICAL";
        int n = s.length();
        int i = 0;
        while (i < n-1) {
            if (s.charAt(i+1) == s.charAt(i)+1) {
                s = s.substring(0, i) + s.substring(i+2, n);
                n-=2;
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        System.out.println(s.length());
        System.out.println(n);
    }
}
