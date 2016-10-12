package maximum_slice;

/**
 * Created by jackson on 8/18/16.
 */
public class MaxDoubleSliceSum {

    /**
     * Using Kanade`s algorithm
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int length = A.length;
        int[] endingMax = new int[length];
        int[] startingMax = new int[length];

        for (int i = 1; i < length - 1; i++) {
            endingMax[i] = Math.max(endingMax[i - 1] + A[i], 0);
        }
        for (int i = length - 2; i > 0; i--) {
            startingMax[i] = Math.max(startingMax[i + 1] + A[i], 0);
        }

        int currentMax = 0;
        for (int i = 1; i < length - 1; i++) {
            currentMax = Math.max(currentMax, endingMax[i - 1] + startingMax[i + 1]);
        }

        return currentMax;
    }

    public static void main(String[] args) {
        new MaxDoubleSliceSum().solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2});
    }
}
