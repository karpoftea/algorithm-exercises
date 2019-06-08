package il.karpov.algorithm.exercises.cci.arrays;

public class Exer16StringCompression {

    // String Compression: Implement a method to perform basic string compression using the counts
    // of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
    // If the "compressed" string would not become smaller than the original string, your method should return
    // the original string. You can assume the string has only uppercase and lowercase letters (a - z).
    public String compress(String word) {
        if (word == null || word.length() < 3) return word;

        int l = word.length();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < l) {
            char c = word.charAt(i);
            int count = 1;
            int j = i + 1;
            while (j < l && word.charAt(j) == c) {
                count++;
                j++;
            }
            sb.append(c).append(count);
            i = j;
        }

        String compressed = sb.toString();
        return compressed.length() < l ? compressed : word;
    }
}
