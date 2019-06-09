package il.karpov.algorithm.exercises.cci.arrays;

import java.util.HashSet;
import java.util.Set;

public class Exer18ZeroMatrix {

    // Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
    // its entire row and column are set to 0.
    public void zeroMatrix(int[][] m) {
        if (m == null || m.length == 0) return;

        Set<Integer> emptyCols = new HashSet<>();
        Set<Integer> emptyRows = new HashSet<>();

        for (int c = 0; c < m.length; c++) {
            for (int r = 0; r < m[0].length; r++) {
                if (m[c][r] == 0) {
                    emptyCols.add(c);
                    emptyRows.add(r);
                }
            }
        }

        for (Integer ec : emptyCols) {
            for (int r = 0; r < m[0].length; r++) {
                m[ec][r] = 0;
            }
        }

        for (Integer er : emptyRows) {
            for (int c = 0; c < m.length; c++) {
                m[c][er] = 0;
            }
        }
    }
}
