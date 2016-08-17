import java.util.Arrays;

/**
 * Created by jackson on 17/08/16.
 */
public class CyclicRotation {

    public static void main(String[] args) {
        int[] A = new int[]{3, 8, 9, 7, 6};
        int k = 3;
        rotate(A, k);
    }

    private static int[] rotate(int[] A, int K) {
        if (A.length > 0 && K > 0) {
            int length = A.length - 1;
            int cicle = 1;
            int[] rotatedArray = Arrays.copyOf(A, A.length);
            while (cicle <= K) {
                rotatedArray[0] = A[length];
                for (int i = 1; i <= length; i++) {
                    rotatedArray[i] = A[i - 1];
                }

                A = Arrays.copyOf(rotatedArray, A.length);
                cicle++;
            }

            return rotatedArray;
        }
        return A;
    }
}
