package prime_composite;

/**
 * Created by jackson on 8/18/16.
 */
public class MinPerimeterRectangule {

    public int solution(int N) {

        Integer x = ((Double) Math.sqrt(N)).intValue();
        int y = 0;
        while (x > 0) {
            if (N % x == 0) {
                y = N / x;
                break;
            }
            x--;
        }

        return 2 * (x + y);
    }

    public static void main(String[] args) {
        new MinPerimeterRectangule().solution(30);
    }
}
