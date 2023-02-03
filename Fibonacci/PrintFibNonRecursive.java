  
  public class Test2 {
      public static void main(String[] args) {
        int n = 10;
        printFibNonRecursive(n);
    }
    public static void printFibNonRecursive(int n) {
        int a = 0, b = 1;
        System.out.printf("f(0) = %d \n" , a);
        System.out.printf("f(1) = %d \n" , b);
        for (int i = 0; i < n; i++) {
            System.out.printf("f(%d) = %d \n" , i, a+b);
            int c = a+b;
            a = b;
            b = c;
        }
    }
 }
