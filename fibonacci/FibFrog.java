package fibonacci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jackson on 8/19/16.
 */
public class FibFrog {

    class FrogJump {
        private int position;
        private int counter;

        public FrogJump(int position, int counter) {
            this.position = position;
            this.counter = counter;
        }

        public int getPosition() {
            return position;
        }

        public int getCounter() {
            return counter;
        }

    }

    public List<Integer> getFibonaci(int max) {
        List<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(1);
        fibonacciNumbers.add(1);
        int f = 1;
        while (fibonacciNumbers.get(f) <= max) {
            fibonacciNumbers.add(fibonacciNumbers.get(f) + fibonacciNumbers.get(f - 1));
            f++;
        }
        fibonacciNumbers.remove(0);
        Collections.reverse(fibonacciNumbers);
        return fibonacciNumbers;
    }

    public int solution(int[] A) {
        // Calculate every fibonacci numbers accord to the length of the array
        List<Integer> fibonacciList = getFibonaci(A.length);
        boolean[] accessed = new boolean[A.length];
        List<FrogJump> jumps = new ArrayList<>();

        //The starter position is -1
        jumps.add(new FrogJump(-1, 0));
        FrogJump currentJump = null;

        int step = 0;
        while (true) {
            if (step == jumps.size()) {
                return -1;
            }

            currentJump = jumps.get(step);
            step++;
            for (int f : fibonacciList) {
                int nextPosition = currentJump.getPosition() + f;
                if (nextPosition == A.length) {
                    return currentJump.getCounter() + 1;
                } else if (nextPosition > A.length || A[nextPosition] == 0 || accessed[nextPosition]) {
                    continue;
                }

                jumps.add(new FrogJump(nextPosition, currentJump.getCounter() + 1));
                accessed[currentJump.getPosition() + f] = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FibFrog().solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
    }
}
