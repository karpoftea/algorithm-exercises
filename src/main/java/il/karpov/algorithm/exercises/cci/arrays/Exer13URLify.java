package il.karpov.algorithm.exercises.cci.arrays;

public class Exer13URLify {

	public void urlify(char[] array, int senEndPos) {
		if (array == null) return;
		
		int al = array.length;
		if (senEndPos >= al) throw new IllegalArgumentException("wrong sentence length");

		int pos = 0;
		while (pos <= senEndPos) {
			if (array[pos] == ' ') {
				if (senEndPos + 2 >= al) throw new IllegalArgumentException("wrong array length");
				shift(array, pos + 1, senEndPos, 2);
				array[pos] = '%';
				array[pos+1] = '2';
				array[pos+2] = '0';
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
