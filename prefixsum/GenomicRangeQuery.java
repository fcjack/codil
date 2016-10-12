package prefixsum;

/**
 * Created by jackson on 8/17/16.
 */


public class GenomicRangeQuery {

    private static int[] solution(String S, int[] P, int[] Q) {
        int[][] genoms = new int[3][S.length() + 1];
        int[] result = new int[P.length];
        short a;
        short c;
        short g;
        for (int i = 0; i < S.length(); i++) {
            a = 0;
            c = 0;
            g = 0;
            if ('A' == (S.charAt(i))) {
                a = 1;
            }
            if ('C' == (S.charAt(i))) {
                c = 1;
            }
            if ('G' == (S.charAt(i))) {
                g = 1;
            }

            genoms[0][i + 1] = genoms[0][i] + a;
            genoms[1][i + 1] = genoms[1][i] + c;
            genoms[2][i + 1] = genoms[2][i] + g;
        }

        for (int j = 0; j < P.length; j++) {
            int begin = P[j];
            int end = Q[j] + 1;

            if (Math.abs(genoms[0][begin] - genoms[0][end]) > 0) {
                result[j] = 1;
            } else if (Math.abs(genoms[1][begin] - genoms[1][end]) > 0) {
                result[j] = 2;
            } else if (Math.abs(genoms[2][begin] - genoms[2][end]) > 0) {
                result[j] = 3;
            } else {
                result[j] = 4;
            }
        }

        return result;


//        //used jagged array to hold the prefix sums of each A, C and G genoms
//        //we don't need to get prefix sums of T, you will see why.
//        int[][] genoms = new int[3][S.length()+1];
//        //if the char is found in the index i, then we set it to be 1 else they are 0
//        //3 short values are needed for this reason
//        short a, c, g;
//        for (int i=0; i<S.length(); i++) {

//            //here we calculate prefix sums. To learn what's prefix sums look at here https://codility.com/media/train/3-PrefixSums.pdf

//        }
//
//        int[] result = new int[P.length];
//        //here we go through the provided P[] and Q[] arrays as intervals
//        for (int i=0; i<P.length; i++) {
//            int fromIndex = P[i];
//            //we need to add 1 to Q[i],
//            //because our genoms[0][0], genoms[1][0] and genoms[2][0]
//            //have 0 values by default, look above genoms[0][i+1] = genoms[0][i] + a;
//            int toIndex = Q[i]+1;

//        }
//
//        return result;
    }


    public static void main(String[] args) {
        solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
    }
}
