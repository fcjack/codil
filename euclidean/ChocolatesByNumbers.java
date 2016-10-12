package euclidean;

/**
 * Created by jackson on 8/19/16.
 */
public class ChocolatesByNumbers {

    private int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        } else {
            return gcd(m, n % m);
        }
    }


    public int solution(int N, int M) {
        int gcd = gcd(N, M);
        return N / gcd;
    }

    public static void main(String[] args) {
        new ChocolatesByNumbers().solution(10, 4);
    }
}
