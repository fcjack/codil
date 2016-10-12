package counting_elements;

public class PermCheck {

    private static final int PERMUTATION = 1;
    private static final int NOT_PERMUTATION = 0;

    private static int solution(int[] A) {
        int[] counter = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (value < 1 || value > A.length) {
                return NOT_PERMUTATION;
            } else {
                if (counter[value - 1] > 0) {
                    return NOT_PERMUTATION;
                } else {
                    counter[value - 1]++;
                }
            }
        }

        return PERMUTATION;
    }

    public static void main(String[] args) {
        int result = solution(new int[]{4, 3, 2, 10});
        System.out.println(result);
    }
}