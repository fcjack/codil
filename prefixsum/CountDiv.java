package prefixsum;

/**
 * Created by jackson on 8/17/16.
 */
public class CountDiv {

    public static int solution(int A, int B, int K) {
        if (A % K == 0)  {
            return (B - A) / K + 1;
        } else {
            return (B - (A - A % K )) / K;
        }
    }

    public static void main(String[] args) {
        int result = solution(6, 11, 2);
        System.out.println(result);
    }
}
