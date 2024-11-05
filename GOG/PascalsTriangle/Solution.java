package GOG.PascalsTriangle;

import java.util.ArrayList;

public class Solution {

    public ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Long> results = new ArrayList<>();
        if (n < 1)
            return results;
        results.add(1l);
        if (n == 1) {
            return results;
        }
        
        ArrayList<Long> prevs = nthRowOfPascalTriangle(n-1);
        
        for (int i=1; i<(n-1); i++) {
            results.add( (prevs.get(i) + prevs.get(i-1)) % 1000000007);
        }

        /*
         * In most programming competitions, we are required to answer the result in 10^9+7 modulo. 
         * The reason behind this is, if problem constraints are large integers, only efficient algorithms can solve them in an allowed limited time.
         * It should just be large enough to fit in an int data type. 2. 
         * It should be a prime number. 10^9 + 7 fits both criteria; which is why you nearly always find 10^9 + 7 in modulo type questions.
         */
        
        results.add(1l);
        return results;
        
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthRowOfPascalTriangle(100));
    }
    
}
