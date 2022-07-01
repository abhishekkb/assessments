import java.util.Arrays;

/**
 * Create a function that takes integer array as input and returns integer array. Inside the function, it requires to rearrange
 * the array elements in such a way that all the positives and zeros are moves to left and negatives are moved to right.
 * This is NOT sorting. Maintain the order of positives and negatives in the same order it is given.
 *
 * int[] Rearrange(int[] inputData)
 * {
 *     // Logic here.
 * }
 *
 * For example:
 * Input:  {5, 3, -3, -4, 0, 2, -1, 4, -7, 2}
 * Output: {5, 3, 0, 2, 4, 2, -3, -4, -1, -7}
 */
public class Assessment2 {

    public static void main(String[] args) {
        int[] list = {5, 3, -3, -4, 0, 2, -1, 4, -7, 2};
        System.out.println(Arrays.toString(rearrange(list)));
    }

    public static int[] rearrange(int[] list){
        int l = list.length;

        int[] posNeg =new int[l];
        int[] neg = new int[l];

        int cp=0;
        int cn=0;

        for (int k : list) {
            if (k >= 0) {
                posNeg[cp++] = k;
            } else {
                neg[cn++] = k;
            }
        }

        System.out.println("pos" + Arrays.toString(posNeg));
        System.out.println("neg" + Arrays.toString(neg));

        for (int i = cp, j=0; i < l; i++, j++) {
            posNeg[i] = neg[j];
        }

        return posNeg;
    }
}
