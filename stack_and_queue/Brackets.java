package stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jackson on 8/18/16.
 */
public class Brackets {

    public int solution(String S) {
        char[] arrayChar = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> match = new HashMap<>();
        match.put('}', '{');
        match.put(']', '[');
        match.put(')', '(');

        for (char c : arrayChar) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.size() == 0 ) return 0;
                Character removed = stack.pop();
                if (match.get(c) != removed) {
                    return 0;
                }
            }
        }

        if (stack.size() == 0) return 1;

        return 0;
    }

    public static void main(String[] args) {
        new Brackets().solution("{[()()]}");
    }
}
