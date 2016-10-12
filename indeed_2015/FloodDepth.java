package indeed_2015;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jackson on 8/18/16.
 */
public class FloodDepth {

    public int solution(int[] A) {

        int maxDepth = 0;
        int start = 0;
        int end = 0;


        int[] top = new int[A.length];
        int max = Integer.MIN_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
            }
            top[i] = max;
        }

        int best = 0;
        for (int i = 0; i < A.length; i++) {
            int c = find(top, A[i]) - i;
            if (c > best) best = c;
            if (best >= A.length - i) return best;
        }

        return best;


//        while (start < a.length && end < a.length) {
//            start = getStart(a, start);
//
//            if (start + 1 < a.length) {
//                end = getEnd(start + 1, a, a[start]);
//                int currentDepth = getMaxDepth(a, start, end);
//
//                if (currentDepth > maxDepth) {
//                    maxDepth = currentDepth;
//                }
//
//                start = end;
//            } else {
//                start = a.length;
//            }
//        }

//        return maxDepth;
    }

    int find(int[] t, int min) {
        int s = 0;
        int e = t.length - 1;

        if (t[e] >= min) return e;

        while (true) {
            int x = (s + e) / 2;
            if (x == t.length - 1) return t.length - 1;
            if (t[x] >= min && t[x + 1] < min) return x;

            if (t[x] < min) e = x;
            else s = x;
        }
    }

    private int getMaxDepth(int[] a, int start, int end) {
        int deepest = 0;
        int iniSize = a[start] >= a[end] ? a[end] : a[start];
        start++;
        for (; start < end; start++) {
            int depth = iniSize - a[start];
            if (depth > deepest) {
                deepest = depth;
            }
        }
        return deepest;
    }

    private int getEnd(int start, int[] a, int size) {
        int higher = Integer.MAX_VALUE;
        int position = 0;

        for (int i = start; i < a.length; i++) {
            int ref = size - a[i];
            if (ref <= 0) {
                return i;
            } else if (ref < higher) {
                higher = ref;
                position = i;
            }
        }
        return position;
    }

    private int getStart(int[] data, int start) {
        for (int i = start; i < data.length; i++) {
            if (i + 1 < data.length && data[i + 1] < data[i]) {
                return i;
            }
        }
        return data.length; // doesn't found any starting point
    }


    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
//        int[] A = new int[]{5,8,1};
//        int[] A = new int[]{3,1,2};
//        int[]A = new int[]{100000000, 1, 2, 99999999};
//        int[]A = new int[]{20, 4, 10, 1, 3};
//        int[] A = new int[]{3, 1, 10, 4, 20};
        System.out.println(new FloodDepth().solution(A));
    }
}


/*

public int solution(int[] A) {
    // write your code in C# 5.0 with .NET 4.5 (Mono)
    int P = -1, R = -1, Q = -1, depth = -1;

    for(int i = 0; i < A.Length - 1; i++){
        if(Q < 0){
            if(A[i] > A[i+1]){
                Q = i +1;
                P = i;
            }
        }
        else{
            if(R < 0){
                if(A[i] > A[i + 1])
                    Q++;

                if(A[i] < A[i + 1])
                    R = i + 1;

                if(A[i] == A[i + 1]){
                    P = Q = R = -1;
                }
            }
            else{
                if(A[i] < A[i + 1])
                    R++;
                else{
                    depth = Math.Max(depth, Math.Min(A[P] - A[Q], A[R] - A[Q]));

                    if(A[i] > A[i + 1]){
                        P = i;
                        Q = i + 1;
                        R = -1;
                    }
                    else{
                        P = Q = R = -1;
                    }
                }
            }
        }
    }

    if(R > 0){
        depth = Math.Max(depth, Math.Min(A[P] - A[Q], A[R] - A[Q]));
    }

    return depth;
}


 */