package il.karpov.algorithm.exercises.intrv.algorithms;

/**
 * Encode string in such a way that is a character is repeated for several times then it will be replaced with it single
 * occurrence and number of times it has occurred. Example: aaabbccc -> a3b2c3.
 * <p><b>Thanks to</b>: <a href="https://www.yandex.ru/">Yandex</a> tech team.</p>
 */
public class RunLengthEncoding {

    public String encode(String word) {
        if (word == null || word.length() < 2) {
            return word;
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);

            int j = i + 1, count = 1;
            while (j < word.length() && word.charAt(j) == c) {
                j++;
                count++;
            }

            sb.append(c);
            if (count > 1) {
                sb.append(count);
            }

            i = i + count;
        }

        String encoded = sb.toString();
        return encoded.length() < word.length() ? encoded : word;
    }
}
