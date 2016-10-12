package euclidean;

/**
 * Created by jackson on 8/19/16.
 */
public class CommonPrimeDivisors {

    private int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        } else {
            return gcd(m, n % m);
        }
    }


    public int solution(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];

            // we know that if two numbers have the same prime divisors then
            // the gcd of both numbers and the result of each number divided by
            // gcd must have the same prime divisors too.
            int gcdOfBoth = gcd(a, b);
            int divisorOfA = a / gcdOfBoth;

            int gcdOfA = gcd(gcdOfBoth, divisorOfA);
            while (gcdOfA != 1) {
                divisorOfA /= gcdOfA;
                gcdOfA = gcd(gcdOfBoth, divisorOfA);
            }

            int divisorOfB = b / gcdOfBoth;
            int gcdOfB = gcd(gcdOfBoth, divisorOfB);
            while (gcdOfB != 1) {
                divisorOfB /= gcdOfB;
                gcdOfB = gcd(gcdOfBoth, divisorOfB);
            }
            if (divisorOfA == 1 && divisorOfB == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        new CommonPrimeDivisors().solution(new int[]{15, 10, 3, 40}, new int[]{75, 30, 5, 25});
    }
}
