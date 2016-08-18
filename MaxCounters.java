/**
 * Created by jackson on 8/17/16.
 */
public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCount = 0;
        int currentMin = 0;

        for (int i = 0; i < A.length; i++) {
            int currentValue = A[i];

            if (currentValue >= 1 && currentValue <= N) {
                if (counters[A[i] - 1] < currentMin) {
                    counters[A[i] - 1] = currentMin;
                }

                counters[currentValue - 1]++;

                if (counters[currentValue - 1] > maxCount) {
                    maxCount = counters[currentValue - 1];
                }
            } else {
                currentMin = maxCount;
            }
        }

        for (int j = 0; j < counters.length; j++) {
            if (counters[j] < currentMin) {
                counters[j] = currentMin;
            }
        }

        return counters;
    }

    public static void main(String[] args) {
        int[] result = solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
    }
}
