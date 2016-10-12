package stack_and_queue;

import java.util.Stack;

/**
 * Created by jackson on 8/18/16.
 */
public class Fish {

    public int solution(int[] A, int[] B) {
        Stack<Integer> fishesToFight = new Stack<>();

        int passedUpstream = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == 0) {
                if (fishesToFight.size() == 0) {
                    passedUpstream++;
                } else {
                    while (!fishesToFight.empty() && A[i] > fishesToFight.peek()) {
                        fishesToFight.pop();
                    }

                    if (fishesToFight.size() == 0) {
                        passedUpstream++;
                    }
                }
            } else {
                fishesToFight.push(A[i]);
            }
        }

        return fishesToFight.size() + passedUpstream;
    }

    public static void main(String[] args) {
        new Fish().solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0});
    }
}
