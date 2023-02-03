import java.util.HashMap;
import java.util.Map;

public class FibRecursive {

    public static void main(String[] args) {
        int n = 10;
        System.out.printf("Fibonacci value of f(%d) = %d\n", n, fib(n));;
    }

    //fibonacci
    public static int fib(int i){
        if(i == 0 || i == 1) {
            return 1;
        }
        return fib(i-1) + fib(i-2);
    }
}
