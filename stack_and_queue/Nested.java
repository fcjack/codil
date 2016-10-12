package stack_and_queue;

import java.util.Stack;

/**
 * Created by jackson on 8/18/16.
 */
public class Nested {

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        char[] charArry = S.toCharArray();

        for (char c : charArry) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return 0;
                stack.pop();
            }
        }

        return stack.size() == 0 ? 1 : 0;

    }

    public static void main(String[] args) {
        new Nested().solution("())");
    }
}
