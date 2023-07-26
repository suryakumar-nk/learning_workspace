import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CandidateTarget {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new LinkedList<>();
        result = calc(target, candidates, 0);
        System.out.println(result.toString());
        System.out.println("list By list:");
        for (List<Integer> val : result) {
            System.out.println(val.toString());
        }
    }

    private static List<List<Integer>> calc(int target, int[] candidates, int startIndex) {
        List<List<Integer>> result = new LinkedList<>();
        int length = candidates.length;
        for (int i=startIndex; i<length; i++) {
            if (target%candidates[i] == 0) {
                int n = target/candidates[i];
                List<Integer> val = new ArrayList<>(n);
                for (int j=0; j<n; j++) {
                    val.add(candidates[i]);
                }
                if (!val.isEmpty()) result.add(val);
            }
            var remaining = target/candidates[i];
            for (int k=1; k<=remaining; k++) {
                int subTarget = target - candidates[i]*k;
                if (subTarget > 0) {
                    var remainingList = calc(subTarget, candidates, i+1);
                    for (List<Integer> val : remainingList) {
                        List<Integer> res = new ArrayList<>();
                        for (int h=0; h<k; h++) {
                            res.add(candidates[i]);
                        }
                        res.addAll(val);
                        result.add(res);
                    }
                }
            }
        }
        return result;
    }
}