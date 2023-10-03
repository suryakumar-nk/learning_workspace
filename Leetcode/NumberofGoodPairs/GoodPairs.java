package NumberofGoodPairs;

import java.util.HashMap;
import java.util.Map;

public class GoodPairs {

    public GoodPairs() {}

    public int numIdenticalPairs(int[] nums)
    {
        int n = nums.length;
        int count = 0;
        for (int i=0; i<n-1; i++)
        {
            for (int j=i+1; j<n; j++)
            {
                if (nums[i] == nums[j]) count++;
            }
        }
        return count;
    }

    public int numIdenticalPairsByMap(int[] nums)
    {
        int count = 0;
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i : nums)
        {
            Integer n = pairs.get(i);
            if (n == null) 
            {
                pairs.put(i, 1);
            } 
            else 
            {
                count+=n;
                pairs.put(i, n+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,1};
        System.out.println(new GoodPairs().numIdenticalPairsByMap(arr));
    }

}
