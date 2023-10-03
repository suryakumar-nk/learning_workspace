package LongestCommonPrefix;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        var prefix = findPrefix(strs[0], strs[1]);
        for (int i=2; i<strs.length ; i++) {
            prefix = findPrefix(prefix, strs[i]);
            if (prefix == "") break;
        }
        return prefix;
    }

    private String findPrefix(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        if (alen == 0 || blen == 0) return "";

        int n = blen;
        if (alen < blen) n = alen;
        StringBuilder str = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (a.charAt(i) == b.charAt(i)) str.append(a.charAt(i));
            else break;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"d g","d ggy","d ggystyle"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
