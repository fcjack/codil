package sorting;

import java.util.Arrays;

/**
 * Created by jackson on 8/18/16.
 */
public class Distinct {

    public static int solution(int[] A) {

        int[] distinctArray = Arrays.stream(A).distinct().toArray();
        return distinctArray.length;
    }

    public static void main(String[] args) {

    }
}
