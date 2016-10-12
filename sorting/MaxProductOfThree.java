package sorting;

import java.util.Arrays;

/**
 * Created by jackson on 8/18/16.
 */
public class MaxProductOfThree {

    public static int solution(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        int P = A[length - 1];
        int Q = A[length - 2];
        int R = A[length - 3];

        int min = A[0];
        int secondMin = A[1];


        int product = P * Q * R;
        int product2 = min * secondMin * P;

        return Math.max(product, product2);
    }

    public static void main(String[] args) {
        int result = solution(new int[]{-3, 1, 2, -2, 5, 6, -20, -10});
        System.out.println(result);
    }
}
