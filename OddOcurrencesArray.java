import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jackson on 17/08/16.
 */
public class OddOcurrencesArray {

    public static int solution(int[] A) {
        Arrays.sort(A);
        int i, j, count = 0;

        for (i = 0; i < A.length; i++) {
            for (j = i + 1; j < A.length; j++) {
                if (A[i] == A[j])
                    count++;
                else
                    break;
            }

            if (count % 2 == 0)
                return A[i];
            else {
                count = 0;
                i = j - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int result = solution(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println(result);
    }
}
