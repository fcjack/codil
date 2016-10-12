package prefixsum;

/**
 * Created by jackson on 8/18/16.
 */
public class MinAvgTwoSlice {

    public static int solution(int[] A) {
        int minStart = 0;
        double minAvg = Double.MAX_VALUE;

        for (int i = 0; i < A.length - 2; i++) {
            double avgOfTwo = (double) (A[i] + A[i + 1]) / 2;

            if (avgOfTwo < minAvg) {
                minAvg = avgOfTwo;
                minStart = i;
            }

            double averageOfThree = (double) (A[i] + A[i + 1] + A[i + 2]) / 3;
            if (averageOfThree < minAvg) {
                minAvg = averageOfThree;
                minStart = i;
            }
        }

        double lastAvgOfTwo = (double) (A[A.length - 1] + A[A.length - 2]) / 2;
        if (lastAvgOfTwo < minAvg) {
            minAvg = lastAvgOfTwo;
            minStart = A.length - 2;
        }

        return minStart;
    }


    public static void main(String[] args) {
        int result = solution(new int[]{10, 10, -1, 2, 4, -1, 2, -1});
        System.out.println(result);
    }
}
