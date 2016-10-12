package maximum_slice;

/**
 * Created by jackson on 8/18/16.
 */
public class MaxProfit {


    public int solution(int[] A) {
        if(A.length == 1 || A.length == 0){
            return 0;
        }

        int maxEnding = 0;
        int maxSlice = 0;
        int minPrice = A[0];

        for (int i = 1; i < A.length; i++) {
            maxEnding = Math.max(0, A[i] - minPrice);
            minPrice = Math.min(minPrice, A[i]);
            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }
}
