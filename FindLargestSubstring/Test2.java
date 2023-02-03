import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
       String s = "pwwkewabff";
       System.out.printf("len of largest substring %s = %d\n", s, lengthOfLargestSubString(s));
    }


    public static int lengthOfLargestSubString(String s){

        Map<Character, Integer> m = new HashMap<>();
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("forloop start i = " + i + " map = " + m + " max = " + max);
            Character x = s.charAt(i);
            if(m.containsKey(x)){
                i = ++j;
                m = new HashMap<>();
                System.out.println("forloop end(continue) i = " + i + " map = " + m + " max = " + max);
                continue;
            }
            m.put(x, 0);
            if (max < m.size()) {
                max = m.size();
            }
            System.out.println("forloop end i = " + i + " map = " + m + " max = " + max);
        }
        System.out.println("max length of substring == " + max);
        return max;
    }

}
