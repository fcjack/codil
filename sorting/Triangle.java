package sorting;

import java.util.Arrays;

/**
 * Created by jackson on 8/18/16.
 */
public class Triangle {

    public static int solution(int[] A) {
        if(null == A || A.length < 3) return 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            long P = A[i];
            long Q = A[i + 1];
            long R = A[i + 2];

            if ((((P + Q) > R) && (Q + R) > P) && ((R + P) > Q)) {
                return 1;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        int result = solution(new int[]{10, 2, 5, 1, 8, 20});
        int result2 = solution(new int[]{10, 50, 5, 1});
        System.out.println(result);
    }
}
