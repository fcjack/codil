package time_complexity;

/**
 * Created by jackson on 8/17/16.
 */
public class FrogJmp {

    public static int solution(int X, int Y, int D) {
        int jumps = (Y - X)/D;
        int mod = (Y - X) % D;

        if (mod > 0) jumps++;
        return jumps;
    }

    public static void main(String[] args) {

        int result = solution(10, 1_000_000_000, 30);

        System.out.println(result);
    }
}
