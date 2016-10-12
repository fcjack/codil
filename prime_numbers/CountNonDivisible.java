package prime_numbers;

import java.util.*;

/**
 * Created by jackson on 8/19/16.
 */
public class CountNonDivisible {

    public int[] solution(int[] A) {

        int N = A.length; //Number of Elements
        int max = getMax(A); //Get Max Element in Array
        int[] counts = getCounts(A, max); //Get Count of Each Element in Array
        int[] cnds = new int[N]; //Array of Counts of Non Divisors

        for (int i = 0; i < N; i++) //Loop Through Array
        {
            int cnd = N; //Set Count of Non Divisors to Number of Elements
            int j; //Traverse of Integers

            for (j = 1; j < Math.sqrt(A[i]); j++) //Loop From 1 to Square Root of Number
            {
                if (A[i] % j != 0) continue; //Skip If Non Divisor

                cnd -= counts[j]; //Subract Count of Divisor
                cnd -= counts[A[i] / j]; //Subtract Count of Quotient
            }
            if (j == Math.sqrt(A[i])) //If Perfect Square
                cnd -= counts[j]; //One Number Double Counted, Adjust

            cnds[i] = cnd; //Set Non Divisor Counts
        }

        return cnds; //Return Array of Counts

    }

    int getMax(int[] A) //Get Max of Array
    {
        int max = A[0]; //Set Max to First Element

        for (int i = 1; i < A.length; i++) //Loop Through Other Elements
            if (A[i] > max) max = A[i]; //Update Max If Bigger Number Than

        return max; //Return Max
    }

    int[] getCounts(int[] A, int max) //Get Count of Each Element in Array
    {
        int[] counts = new int[max + 1]; //Array of Counts of Each Element

        for (int i = 0; i < A.length; i++) //Loop Through Array
            counts[A[i]]++; //Increment Count of Each Element

        return counts; //Return Array of Counts
    }

    public static void main(String[] args) {
        int i = 0;
        int[] data = new int[20_000];
        Random random = new Random();
        int min = 1;
        int max = 40_000;

        while (i < 20_000) {
            int randomInt = random.nextInt(max - min + 1) + min;
            if (randomInt < 0) randomInt = randomInt * -1;
            data[i] = randomInt;
            i++;
        }

        new CountNonDivisible().solution(new int[]{3, 1, 2, 3, 6});
    }
}