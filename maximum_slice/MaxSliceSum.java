package maximum_slice;

/**
 * Created by jackson on 8/18/16.
 */
public class MaxSliceSum {


    public int solution(int[] A) {
        int maxEnding = A[0];
        int maxSlice = A[0];

        for (int i = 1; i < A.length; i++) {
            maxEnding = Math.max(A[i], maxEnding + A[i]);
            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }


    public static void main(String[] args) {
        new MaxSliceSum().solution(new int[]{3, 2, -6, 4, 0});
    }
}
