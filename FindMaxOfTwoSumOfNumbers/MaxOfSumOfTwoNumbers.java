
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function given array A consisting of N integers, returns the maximum sum of two numbers whose digits add up to an equal sum. If there are no two numbers whose digits have an equal sum, the function should return -1.
 *
 * Examples:
 *
 * Given A =[51, 71, 17, 42], the function should return 93. There are two pairs of numbers whose digits add up to an equal sum: (51,42) and(17,71). The first pairs sums up to 93.
 *
 * Given A =[42, 33, 60], the function should return 102. The digits of all numbers in A add up to the same sum, and choosing to add 42 and 60 gives the result 102.
 *
 * Given A =[51, 32, 43], the function should return -1, since all numbers in A have digits that add up to different, unique sums
 */
public class MaxOfSumOfTwoNumbers {

    public static void main(String[] args) {

        System.out.println("============"+getSum(51));
        System.out.println("============"+getSum(71));
        System.out.println("============"+getSum(17));
        System.out.println("============"+getSum(42));

        System.out.println("sum = " + getMax1(new int[]{51, 71, 17, 42}));
        System.out.println("sum = " + getMax1(new int[]{42, 33, 60}));
        System.out.println("sum = " + getMax1(new int[]{51, 32, 43}));

        System.out.println("sum = " + getMax2(new int[]{51, 71, 17, 42}));
        System.out.println("sum = " + getMax2(new int[]{42, 33, 60}));
        System.out.println("sum = " + getMax2(new int[]{51, 32, 43}));

    }

    static int getMax1(int[] a){
        int max=-1;
        int n = a.length;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int si = getVal1(sums, a, i);
            for (int j = 0; j < n; j++) {
                int sj = getVal1(sums, a, j);
//                System.out.printf("a[i = %d] = %d, a[j = %d] = %d, si = %d, sj = %d\n", i, a[i], j, a[j], si, sj );
                if(si == sj && i != j && a[i]+a[j] > max){
                    max = a[i] + a[j];
//                    System.out.printf("max = %d\n", max);
                }
            }
        }
        return max;
    }

    static int getMax2(int[] a) {
        int max=-1;
        int n = a.length;
        // sum -> i, j, k ... (indexes of elements in array a)
        Map<Integer, List<Integer>> sums = new HashMap<>();
        for (int i = 0; i < n; i++) {
            addToMap(sums, a, i);
        }
        for(Map.Entry<Integer, List<Integer>> entry: sums.entrySet()){
            List<Integer> x = entry.getValue();
            for (int i = 0; i < x.size(); i++) {
                for (int j = 1; j < x.size(); j++) {
                    if(!x.get(i).equals(x.get(j)) && i!=j) {
                        int temp = a[x.get(i)] + a[x.get(j)];
                        if (temp > max) {
                            max = temp;
                        }
                    }
                }
            }
        }


        return max;
    }

    static void addToMap(Map<Integer, List<Integer>> sums, int[] a, int i) {
        int s = getSum(a[i]);
        List<Integer> l;
        if(sums.containsKey(s)){
            l = sums.get(s);
        } else {
            l = new ArrayList<>();
        }
        l.add(i);
        sums.put(s, l);
    }

    static int getVal1(List<Integer> sums, int[] a, int i){
        int s =0;
        if(sums.contains(i)){
            s = sums.get(i);
        } else {
            s = getSum(a[i]);
            sums.add(i, s);
        }
        return s;
    }
    static int getSum(int x){
        int sum=0;
        do{
            sum += x % 10;
            x /= 10;
        }while(x!=0);
        return sum;
    }
}
