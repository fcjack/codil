package binary_search;

/**
 * Created by jackson on 8/19/16.
 */
public class MinMaxDivision {

    public int solution(int K, int M, int[] A) {
        long length = A.length;
        long maxSum = M * length;
        long min = 0;
        long result = 0;

        while (min <= maxSum) {
            long mid = (min + maxSum) / 2;
            int count = 0;
            long sum = 0;
            for (long ele : A) {
                sum += ele;
                // there is an element which is larger than the large sum, so it
                // is not a valid trial
                if (ele > mid) {
                    count = K + 1;
                    break;
                }

                if (sum > mid) {
                    count++;
                    sum = ele;
                }
            }

            count++;

            if (count <= K) {
                maxSum = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }

        return (int) result;


    }

    public static void main(String[] args) {
        new MinMaxDivision().solution(3, 5, new int[]{2, 1, 5, 1, 2, 2, 2});
    }

}
