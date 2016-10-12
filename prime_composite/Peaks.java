package prime_composite;

import java.util.ArrayList;

/**
 * Created by jackson on 8/18/16.
 */
public class Peaks {

    public int solution(int[] A) {
        int length = A.length;

        // Find all the peaks
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) peaks.add(i);
        }

        for (int size = 1; size <= length; size++) {

            if (length % size != 0) {
                continue; // skip if non-divisible
            }

            int find = 0;
            int groups = length / size;
            boolean finished = true;

            // Find whether every group has a peak
            for (int peakIdx : peaks) {
                if (peakIdx / size > find) {
                    finished = false;
                    break;
                }

                if (peakIdx / size == find) {
                    find++;
                }
            }
            if (find != groups) {
                finished = false;
            }
            if (finished) {
                return groups;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,5,3,4,3,4,1,2,3,4,6,2};
        new Peaks().solution(A);
    }
}
