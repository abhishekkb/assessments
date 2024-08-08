import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairInListMatchingASum {
    /**
     * Given a collection of numbers (both positive and negative) can you find a pair that will match a given sum.
     * Example:
     * [1,2,3,4] Sum = 8 // return false
     * [1,2,3,5] Sum = 6 // return true
     *
     * @param numbers int[]
     * @param sum int
     * @return isTrue boolean
     */
    private static boolean findPairWithSum(int[] numbers, int sum) {
//        Set<Integer> nums = new HashSet<>(Arrays.asList(Arrays.stream(numbers).boxed().toArray(Integer[]::new)));
        Set<Integer> nums = new HashSet<>();
        for (int num : numbers) {
            int diff = sum - num;
            boolean containsDiff = nums.contains(diff);
            if (containsDiff) {
                return true;
            } else {
                nums.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] c1 = {1,2,3,4};
        int[] c2 = {1,2,3,5};
        int[] c3 = {1,2,3,4};
        System.out.println(findPairWithSum(c1, 8));
        System.out.println(findPairWithSum(c2, 8));
        System.out.println(findPairWithSum(c3, 7));
    }
}
