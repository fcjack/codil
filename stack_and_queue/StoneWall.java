package stack_and_queue;

import java.util.Stack;

/**
 * Created by jackson on 8/18/16.
 */
public class StoneWall {

    public static int solution(int[] data) {
        Stack<Integer> stack = new Stack<>();
        int stones = 1;
        stack.push(data[0]);

        for (int i = 1; i < data.length; i++) {
            while (!stack.isEmpty() && stack.peek() > data[i]) {
                stack.pop();
            }

            if (!(!stack.isEmpty() && stack.peek() == data[i])) {
                stack.push(data[i]);
                stones++;
            }
        }

        return stones;
    }

    public static void main(String[] args) {
        new StoneWall().solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8});
    }
}
