package sorting;

/**
 * Created by jackson on 8/18/16.
 */
public class NumberOfDiscIntersections {
    private final int TEN_MILLION = 10000000;

    public int solution(int[] A) {
        int N = A.length;
        int count = 0;
        int[] num_no_intersect = new int[N + 1];

        for (int J = 0; J < N; J++) {
            if (J <= A[J]) {
                count += J;
            } else {
                count += J - num_no_intersect[J - A[J]];
            }

            if (count > TEN_MILLION) return -1; // check for exceptional case

            num_no_intersect[J + 1] += num_no_intersect[J]; // discs b/f position J also won't intersect position J+1
            if (A[J] < N && J + A[J] + 1 < N) { // check bounds on A[J] to avoid arithmetic overflow
                num_no_intersect[J + A[J] + 1]++; // disc J will not intersect positions on or after position J+A[J]+1
            }
        }
        return count;
    }

}