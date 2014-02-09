
import java.util.*;
import java.lang.*;

public class WordScramble {

    public static void main (String[] args) throws java.lang.Exception
    {
        // User needs to specify a string to create permutations of
        if (args.length < 1) {
            throw new IllegalArgumentException("Please pass in a string");
        }

        makePermutations("", args[0]);
    }

    private static void makePermutations(String remainder, String originalWord) {
        // Using a set to track unique permutations - this will work with Unicode chars
        Set<Character> usedChars = new HashSet<Character>();

        // Base case
        if(originalWord.length() == 0) {
            System.out.println(remainder);
        }

        for(int i = 0; i < originalWord.length(); i++) {
            // if char has been seen before, don't create permutations with it again.
            if(usedChars.contains(originalWord.charAt(i))) continue;
            usedChars.add(originalWord.charAt(i));

            // new input string (minus the char that will be put into new positions)
            String newOriginal = originalWord.substring(0, i) + originalWord.substring(i+1);
            String newRemainder = remainder + originalWord.charAt(i);

            // recursive call
            makePermutations(newRemainder, newOriginal);
        }
    }
}