package il.karpov.algorithm.exercises.cci.arrays;

public class Exer15OneAway {

    // One Away: There are three types of edits that can be performed on strings: insert a character,
    // remove a character, or replace a character. Given two strings, write a function to check if they are
    // one edit (or zero edits) away.
    // EXAMPLE
    //	pale, ple -> true
    //	pales, pale -> true
    // 	pale, bale -> true
    // 	pale, bake -> false
    public boolean isOneAway(String one, String two) {
        if (one == null || two == null) throw new IllegalArgumentException();

        int diff = one.length() - two.length();
        if (diff > 1 || diff < -1) return false;

        int charDiff = 0;
        if (diff == 0) {
            for (int i = 0; i < one.length() && charDiff < 2; i++) {
                if (one.charAt(i) != two.charAt(i)) charDiff++;
            }
            return charDiff < 2;
        } else {
            String smaller = diff == 1 ? two : one;
            String bigger = diff == 1 ? one : two;
            for (int i = 0; i < smaller.length() && charDiff < 2; i++) {
                if (smaller.charAt(i) != bigger.charAt(i + charDiff)) charDiff++;
            }
            return charDiff < 2;
        }
    }
}
