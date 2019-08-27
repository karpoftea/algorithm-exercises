package il.karpov.algorithm.exercises.cci.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 1.4
// Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
// A palindrome is a word or phrase that is the same forwards and backwards.
// A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
// EXAMPLE
// Input: Tact Coa
// Output: True (permutations: "taco cat", "atco eta", etc.) Hints:#106,#121,#134,#136
public class Exer14PalindrPermuts {

    private java.util.Set<Character> SPECIAL_SYMBOLS = new HashSet<>(java.util.Arrays.asList(' ', ','));

    public boolean isPalindrPermut(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        int legalChars = 0;
        Map<Character, Integer> hist = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (!SPECIAL_SYMBOLS.contains(word.charAt(i))) {
                Integer count = hist.get(word.charAt(i));
                hist.put(word.charAt(i), count == null ? 1 : ++count);
                ++legalChars;
            }
        }

        if (legalChars == 0) {
            return true;
        }

        int allowedOddChars = legalChars % 2;
        for (Integer charsCount : hist.values()) {
            if (charsCount % 2 != 0) {
                if (allowedOddChars > 0) {
                    --allowedOddChars;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
