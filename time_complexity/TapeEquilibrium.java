package time_complexity;

import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by jackson on 8/17/16.
 */
public class TapeEquilibrium {


    private static int solution(int[] A) {
        int[] sum1 = new int[A.length - 1];
        int[] sum2 = new int[A.length - 1];

        sum1[0] = A[0];
        sum2[A.length - 2] = A[A.length - 1];

        for (int i = 1; i < A.length - 1; i++) {
            sum1[i] = sum1[i - 1] + A[i];
        }

        for (int i = A.length - 3; i >= 0; i--) {
            sum2[i] = sum2[i + 1] + A[i + 1];
        }

        int minValue = Integer.MAX_VALUE;
        for (int j = 0; j < sum1.length; j++) {
            int sum = Math.abs(sum1[j] - sum2[j]);
            if (sum < minValue)
                minValue = sum;
        }

        return minValue;

    }


    public static void main(String[] args) {
        int i = 0;
        int[] array = new int[100_000];
        Random random = new Random();
        int min = -100;
        int max = 100;

        while (i < 100_000) {
            array[i] = random.nextInt(max - min + 1) + min;
            i++;
        }

        System.out.println(new Date());
        int result = solution(array);

        System.out.println(new Date());

        System.out.println(result);
    }
}
