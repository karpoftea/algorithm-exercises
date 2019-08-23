package il.karpov.algorithm.exercises.cci.arrays;

// 1.3
// URLify: Write a method to replace all spaces in a string with '%20'.
// You may assume that the string has sufficient space at the end to hold the additional characters,
// and that you are given the "true" length of the string.
// (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
//	EXAMPLE
//	Input: "Mr John Smith    ", 13
//	Output: "Mr%20John%20Smith"
public class Exer13URLify {

    public void urlify(char[] array, int senEndLength) {
        if (array == null) return;

        int al = array.length;
        if (senEndLength >= al) throw new IllegalArgumentException("wrong sentence length");

        int pos = 0;
        int senEndPos = senEndLength - 1;
        while (pos <= senEndPos) {
            if (array[pos] == ' ') {
                if (senEndPos + 2 >= al) throw new IllegalArgumentException("wrong array length");
                shift(array, pos + 1, senEndPos, 2);
                array[pos] = '%';
                array[pos + 1] = '2';
                array[pos + 2] = '0';
                pos += 3;
                senEndPos += 2;
            } else {
                pos++;
            }
        }
    }

    private void shift(char[] array, int start, int end, int offset) {
        for (int i = end; i >= start; i--) {
            array[i + offset] = array[i];
        }
    }
}
