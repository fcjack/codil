/**
 * Created by jackson on 8/17/16.
 */

public class FrogRiverOne {

    private static int solution(int X, int[] A) {

        int steps = X;
        boolean[] bitmap = new boolean[X];
        for (int i = 0; i < A.length; i++) {
            if (!bitmap[A[i] - 1]) {
                bitmap[A[i] - 1] = true;
                steps--;
            }
            if (steps == 0) return i;
        }
        return -1;

    }


    public static void main(String[] args) {
        int result = solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        System.out.println(result);
    }
}
