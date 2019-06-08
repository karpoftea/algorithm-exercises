package il.karpov.algorithm.exercises.cci.arrays;

import java.util.HashMap;
import java.util.Map;

public class Exer12IsPermutation {

//    Check Permutation: Given two strings,write a method to decide if one is a permutation of the
//    other.
    public boolean isPermutation(String ethalon, String word) {
        // O(e + w)
        if (ethalon == null || word == null) return false;
        if (ethalon.length() != word.length()) return false;

        Map<Character, Integer> eHist = getCharHist(ethalon);
        Map<Character, Integer> wHist = getCharHist(word);

        if (eHist.size() != wHist.size()) return false;

        return eHist.entrySet().stream().noneMatch(e -> {
            Integer wCount = wHist.get(e.getKey());
            return !e.getValue().equals(wCount);
        });
    }

    private Map<Character, Integer> getCharHist(String word) {
        Map<Character, Integer> hist = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Integer count = hist.get(c);
            hist.put(c, count == null ? 1 : ++count);
        }
        return hist;
    }
}
