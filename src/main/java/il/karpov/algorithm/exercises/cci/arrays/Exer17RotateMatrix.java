package il.karpov.algorithm.exercises.cci.arrays;

public class Exer17RotateMatrix {

    // Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
    // write a method to rotate the image by 90 degrees. Can you do this in place?
    public int[][] rotateMatrix(int[][] m) {
        if (m == null) return null;
        if (m[0].length != m.length) throw new IllegalArgumentException();

        int n = m[0].length;
        int[][] m1 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m1[j][i] = m[i][n - 1 - j];
            }
        }
        return m1;
    }
}
