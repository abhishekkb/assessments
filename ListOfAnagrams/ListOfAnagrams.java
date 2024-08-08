import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ListOfAnagrams {


    public static void main(String[] args) {
        String[] strs = {"tac", "bed", "deb", "dog", "cat"};

    }

    /**
     * Given list of String {'tac', 'bed', 'deb', 'dog', 'cat'}, return a Set of String where each list contains all Strings which are anagrams of each other. Two words are anagrams of
     * each other if the letter can be rearranged to make each other.
     * {
     * {'tac', 'cat'},
     * {'bed', 'deb'},
     * {'dog'}// * }
     *
     * @param args
     * @return list of set
     */
    private static List<List<String>> anagrams(String[] args) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : args) {
            String ss = sortStringChars(s);
            if (anagrams.containsKey(ss)) {
                anagrams.get(ss).add(s);
            } else {
                anagrams.put(ss, new ArrayList<>(Collections.singletonList(s)));
            }
        }
        return new ArrayList<>(anagrams.values());
    }

    static String sortStringChars(String s) {

        //TODO implement
        return null;
    }

}




