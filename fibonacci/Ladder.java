package fibonacci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jackson on 8/19/16.
 */
public class Ladder {

    public int[] getFibonaci(int max) {
        int[] fibonacciNumbers = new int[max];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;
        int f = 2;
        while (fibonacciNumbers[f] <= max) {
            fibonacciNumbers[f] = (fibonacciNumbers[f-1] + fibonacciNumbers[f-2]);
            f++;
        }

        return fibonacciNumbers;
    }

    public int[] solution(int[] A, int[] B) {
        int length = A.length;
        int[] fib = new int[length];
        int maxModulo = (int) Math.pow(2, 30);
        int a = 0;
        int b = 1;

        for (int i = 0; i < length; i++) {
            int x = (a + b) % maxModulo;
            fib[i] = x;
            a = b;
            b = x;
        }

        int[] result = new int[A.length];
        int[] modulo = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            modulo[i] = (int) Math.pow(2, B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            result[i] = fib[A[i] - 1] % modulo[i];
        }

        return result;


        /*

        int[] fib = new int[A.length];
        int a = 0;
        int b = 1;
        int maxModulo = (int) Math.pow(2, 30);
        for (int i = 0; i < A.length; i++) {
            int x = (a + b) % maxModulo;
            fib[i] = x;
            a = b;
            b = x;
        }

        int[] result = new int[A.length];
        int[] modulo = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            modulo[i] = (int) Math.pow(2, B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            result[i] = fib[A[i] - 1] % modulo[i];
        }

        return result;

         */
    }

    public static void main(String[] args) {
        new Ladder().solution(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1});
    }
}
