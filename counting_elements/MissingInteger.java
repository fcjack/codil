package counting_elements;

/**
 * Created by jackson on 8/17/16.
 */
public class MissingInteger {

    private static int solution(int[] A) {
        int N = A.length;
        boolean[] numPresent = new boolean[A.length + 1];

        for (int i = 0; i < N; i++) {
            if (A[i] < 1 || A[i] > N) {
                continue;
            }

            if (!numPresent[A[i]]) {
                numPresent[A[i]] = true;
            }
        }

        int smallest = 1;
        for (int j = 1; j < numPresent.length; j++) {

            if (!numPresent[j]) {
                smallest = j;
                break;
            }
            smallest++;
        }

        return smallest;
    }


    public static void main(String[] args) {
        int result = solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(result);
    }
}
