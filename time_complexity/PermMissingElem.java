package time_complexity;

import java.util.Arrays;

/**
 * Created by jackson on 8/17/16.
 */
public class PermMissingElem {

    public static int solution(int[] A) {
        int N = A.length + 1;

        int paSum = (N * (N + 1)) / 2;

        int sum = Arrays.stream(A).sum();

        return Math.abs(sum - paSum);
    }

    public static void main(String[] args) {

        int[] array = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            if ((i + 1) == 10001) {
                continue;
            }
            array[i] = i + 1;
        }

        int result = solution(array);
        System.out.println(result);
    }
}
