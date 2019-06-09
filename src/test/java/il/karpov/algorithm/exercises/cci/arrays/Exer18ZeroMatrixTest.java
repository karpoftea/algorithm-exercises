package il.karpov.algorithm.exercises.cci.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer18ZeroMatrixTest {

    @DataProvider
    public static Object[][] getMatrices() {
        return new Object[][]{
                {new int[][]{}, new int[][]{}},
                {new int[][]{{1}}, new int[][]{{1}}},
                {new int[][]{{0}}, new int[][]{{0}}},
                {new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2}, {3, 4}}},
                {new int[][]{{1, 2}, {0, 4}}, new int[][]{{0, 2}, {0, 0}}},
                {new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{1, 2, 3}, {4, 5, 6}}},
                {new int[][]{{1, 2, 0}, {4, 0, 6}}, new int[][]{{0, 0, 0}, {0, 0, 0}}}
        };
    }

    @Test(dataProvider = "getMatrices")
    public void zeroMatrix_should_setToZeroRowAndColumnWithZeroElement(int[][] matrix, int[][] expected) {
        Exer18ZeroMatrix exer = new Exer18ZeroMatrix();
        exer.zeroMatrix(matrix);

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Assert.assertEquals(matrix[i], expected[i]);
        }
    }
}
