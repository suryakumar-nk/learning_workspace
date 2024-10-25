package RemoveSubFoldersFromFileSystem;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String lastFolder = ans.get(ans.size() - 1) + "/";
            if (!folder[i].startsWith(lastFolder)) {
                ans.add(folder[i]);
            }
        }
        System.out.println(ans);
    }
}
