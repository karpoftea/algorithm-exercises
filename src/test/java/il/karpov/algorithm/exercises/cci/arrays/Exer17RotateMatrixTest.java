package il.karpov.algorithm.exercises.cci.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer17RotateMatrixTest {

    @DataProvider
    public static Object[][] getMatrices() {
        return new Object[][]{
                {
                        new int[][]{{1}},
                        new int[][]{{1}},
                },
                {
                        new int[][]{{1, 3}, {2, 4}},
                        new int[][]{{3, 4}, {1, 2}}
                },
                {
                        new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}},
                        new int[][]{{7, 8, 9}, {4, 5, 6}, {1, 2, 3}}
                },
                {
                        new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}},
                        new int[][]{{13, 14, 15, 16}, {9, 10, 11, 12}, {5, 6, 7, 8}, {1, 2, 3, 4}}
                }
        };
    }

    @Test(dataProvider = "getMatrices")
    public void rotateMatrix_should_rotateMatrinOn90Degrees(int[][] matrix, int[][] rotated) {
        Exer17RotateMatrix exer = new Exer17RotateMatrix();
        int[][] actual = exer.rotateMatrix(matrix);

        int n = actual.length;
        for (int i = 0; i < n; i++) {
            Assert.assertEquals(actual[i], rotated[i]);
        }
    }
}
