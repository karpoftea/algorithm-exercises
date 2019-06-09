package il.karpov.algorithm.exercises.cci.arrays;

public class Exer19StringRotation {

	// String Rotation:Assumeyou have a method isSubstringwhich checks if one word is a substring of another.
	// Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call
	// to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
	public boolean isStringRotation(String o, String r) {
		if (o == null || r == null) throw new IllegalArgumentException();
		if (o.length() != r.length()) return false;
		
		int origLastMatchPos = -1;
		int rotFirstMatchPos = -1;

		for (int i = 0; i < r.length(); i++) {
			if (o.charAt(origLastMatchPos + 1) == r.charAt(i)) {
				origLastMatchPos += 1;
				if (rotFirstMatchPos == -1) rotFirstMatchPos = i;
			} else {
				origLastMatchPos = -1;
				rotFirstMatchPos = -1;
			}
		}

		if (origLastMatchPos == o.length() - 1) return true;
		if (rotFirstMatchPos == -1) return false;

		return o.substring(origLastMatchPos + 1).contains(r.substring(0, rotFirstMatchPos));
	}
}
