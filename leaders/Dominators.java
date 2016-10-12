package leaders;

/**
 * Created by jackson on 8/18/16.
 */
public class Dominators {

    public int solution(int[] A) {
        int[] data = A;
        int count = 0;
        int candidate = 0;

        for (int i = 0; i < data.length; i++) {
            if (count == 0) {
                count++;
                candidate = data[i];
            } else {
                if (data[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        int ocurrence = 0;
        int leaderIndex = -1;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == candidate) {
                ocurrence++;
                if (leaderIndex < 0) leaderIndex = i;
            }
        }

        if (ocurrence > (data.length / 2)) {
            return leaderIndex;
        }

        return -1;

    }


    public static void main(String[] args) {
        new Dominators().solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3});
    }
}
