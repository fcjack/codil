package prime_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jackson on 8/19/16.
 */
public class SemiprimesCount {

    public int[] solution(int N, int[] P, int[] Q) {
        boolean[] sieve = creatingSieveArray(N);
        List<Integer> primes = createPrimeArray(sieve);

        // Counting the semiprimes that are found
        int[] semiprimes = new int[N + 1];
        int[] sp = new int[N + 1];
        long semiprime = 0;
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                semiprime = (long) primes.get(i) * (long) primes.get(j);
                if (semiprime > N) {
                    break;
                }
                semiprimes[(int) semiprime] = 1;
                sp[(int) semiprime] = 1;
            }
        }


        // Prefix sum in this semiprime array
        for (int i = 1; i < semiprimes.length; i++) {
            semiprimes[i] += semiprimes[i - 1];
        }


        // Calculate the result in the position requested
        int[] count = new int[Q.length];
        for (int i = 0; i < Q.length; i++) {
            count[i] = semiprimes[Q[i]] - semiprimes[P[i]] + sp[P[i]];
        }

        return count;
    }

    private boolean[] creatingSieveArray(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        int i = 2;
        while (i * i <= n) {
            if (sieve[i]) {
                int k = i * i;
                while (k <= n) {
                    sieve[k] = false;
                    k += i;
                }
            }
            i++;
        }

        return sieve;
    }

    private List<Integer> createPrimeArray(boolean[] sieve) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        System.out.println(new SemiprimesCount().solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20}));
    }
}
