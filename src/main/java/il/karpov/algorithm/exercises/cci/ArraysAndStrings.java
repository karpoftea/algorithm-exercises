package il.karpov.algorithm.exercises.cci;

public class ArraysAndStrings {
	
	// Interview Questions

	// 1.1. 
	// Is Unique: Implement an algorithm to determine if a string has all unique characters. 
	// What if you cannot use additional data structures?
	public boolean isUnique(String word) {
		// O(n^2)
		if (word == null || word.length() == 0) return true;
		
		boolean isUnique = true;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			for (int j = i + 1; j < word.length(); j++) {
				if (c == word.charAt(j)) {
					isUnique = false;
					break;
				}
			}

			if (!isUnique) break;
		}
		return isUnique;
	}
}