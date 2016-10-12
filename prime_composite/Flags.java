package prime_composite;

/**
 * Created by jackson on 8/18/16.
 */
public class Flags {

    public int solution(int[] A) {
        int length = A.length;
        int[] next = nextPeak(A);
        int i = 1;
        int result = 0;

        while ((i - 1) * i <= length) {
            int pos = 0;
            int num = 0;
            while (pos < length && num < i) {
                pos = next[pos];
                if (pos == -1) {
                    break;
                }
                num++;
                pos += i;
            }
            result = Math.max(result, num);
            i++;
        }

        return result;
    }

    private int[] nextPeak(int[] data) {
        int n = data.length;
        boolean[] peaks = createPeaks(data);
        int[] next = new int[data.length];
        next[n - 1] = -1;

        for (int i = n - 2; i > -1; i--) {
            if (peaks[i]) {
                next[i] = i;
            } else {
                next[i] = next[i + 1];
            }
        }

        return next;

    }

    private boolean[] createPeaks(int[] data) {
        boolean[] peaks = new boolean[data.length];

        for (int i = 1; i < data.length - 1; i++) {
            if (data[i] > Math.max(data[i - 1], data[i + 1])) {
                peaks[i] = true;
            }
        }

        return peaks;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,5,3,4,3,4,1,2,3,4,6,2};
        new Flags().solution(A);
    }
}
