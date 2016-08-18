/**
 * Created by jackson on 8/17/16.
 */
public class PassingCars {


    public static int solution(int[] A) {
        int passing = 0;
        int west = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 0) {
                passing += west;
                if (passing > 1_000_000_000) return -1;
            } else {
                west++;
            }
        }

        return passing;
    }

    public static void main(String[] args) {
        int result = solution(new int[]{0,1,0,1,1});
        System.out.println(result);
    }
}
