package prime_composite;

/**
 * Created by jackson on 8/18/16.
 */
public class CountFactors {

    public int solution(int N) {
        long i = 1;
        int result = 0;
        while ((i * i) < N) {
            if (N % i == 0) {
                result += 2;
            }
            i++;
        }

        if ((i * i) == N) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        new CountFactors().solution(Integer.MAX_VALUE);
    }

}
