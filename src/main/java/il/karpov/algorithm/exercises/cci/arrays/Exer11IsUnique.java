package il.karpov.algorithm.exercises.cci.arrays;

import java.util.HashMap;
import java.util.Map;

// 1.1
// Is Unique: Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?
public class Exer11IsUnique {

    // O(n^2) CPU
    // O(n) mem
    public boolean isUnique(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        boolean isUnique = true;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = i + 1; j < word.length(); j++) {
                if (c == word.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (!isUnique) {
                break;
            }
        }
        return isUnique;
    }

    public boolean isUnique2(String word) {
        // O(n) CPU
        // O(n) mem
        if (word == null || word.length() == 0) {
            return true;
        }

        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Integer count = chars.get(c);
            count = count == null ? 1 : ++count;
            if (count > 1) {
                return false;
            }
            chars.put(c, count);
        }
        return true;
    }

    public boolean isUnique3(String word) {
        // O(n) CPU
        // O(n) mem
        // characters are only ASCII
        if (word == null || word.length() == 0) {
            return true;
        }

        int[] chars = new int[128];
        for (int i = 0; i < word.length(); i++) {
            if (++chars[word.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }
}

