import java.util.Arrays;

/**
 * package com.mettl;
 * <p>
 * import java.util.Arrays;
 * <p>
 * 1, 2, 3, ... k
 * k+1, k+2, k+3,...k+k
 * /*
 * You are distributing N candies to K children. You give 1 candy to the first child, 2 candies to the second child,
 * 3 candies to the third child and so on till K children have received the candies. You then start from the first child
 * again and give him/her K+1 candies, K+2 candies to the second child and so on till all the candies are distributed.
 * <p>
 * Find the number of candies that each child gets.
 * <p>
 * Input Specification:
 * input1: The number of candies N.
 * input2: The number of children K.
 * <p>
 * Output Specification:
 * <p>
 * Return array A representing the candies all children get where A[i] is the number of candies received by ith child.
 * <p>
 * Example 1:
 * input1: 7
 * input2: 4
 * <p>
 * The number of candies N.
 * Tne number of children K.
 * <p>
 * Specification:
 * array A representing the candies all children get where A[i] is the number les received by ith child.
 * Sample 1:
 * input1: 7
 * input2: 4
 * Output: (1,2,3,1}
 * Explanation:
 * Here, the first child gets 1 candy, second child gets 2 candies, third child gets 3 candies and now you have only
 * 1 candy left, so you give it to the fourth child.
 * Example 2:
 * input1: 10
 * input2: 3
 * Output: (5,2,3)
 * Explanation:
 * Here, the first child gets 1 candy, second child gets 2 candies, third child gets 3 candies and now you go back
 * to the first child and give him/her 4(K+1 3+1 = 4) candies which are all that you have.
 */


public class Test4 {
    private static int[] a;
    private static int n = 10;
    private static int k = 3;

    public static void main(String[] args) {
        a = new int[k];
        distribute();
        System.out.println(Arrays.toString(a));
    }

    public static void distribute() {
        dist(0);
        dist(k);
    }

    public static void dist(int base) {
        for (int i = 0; i < k; i++) {
            if (n <= base + i + 1) {
                a[i] = a[i] + n;
                n = 0;
                break;
            }
            a[i] = a[i] + base + i + 1;
            n = n - (i + 1);
        }
    }
}
