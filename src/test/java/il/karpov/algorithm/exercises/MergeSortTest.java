package il.karpov.algorithm.exercises;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MergeSortTest {

    @Test(dataProvider = "getMergedArrays")
    public void mergeRcr_should_mergeSortedArrays(int[] a, int[] b, int[] expected) {
        Assert.assertTrue(Arrays.equals(MergeSort.mergeRcr(a, b), expected));
    }

    @DataProvider
    private static Object[][] getMergedArrays() {
        return new Object[][] {
            { new int[0], new int[] { 1 }, new int[] { 1 } },
            { new int[] { 1 }, new int[0], new int[] { 1 } },

            { new int[] { 1 }, new int[] { 1 }, new int[] { 1, 1 } },

            { new int[] { 1, 2 }, new int[] { 3, 4 }, new int[] { 1, 2, 3, 4 } },
            { new int[] { 3, 4 }, new int[] { 1, 2 }, new int[] { 1, 2, 3, 4 } },

            { new int[] { 1, 6 }, new int[] { 2, 4 }, new int[] { 1, 2, 4, 6 } },
            { new int[] { 2, 4 }, new int[] { 1, 6 }, new int[] { 1, 2, 4, 6 } },

            { new int[] { 1, 3 }, new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 } },
            { new int[] { 2, 4 }, new int[] { 1, 3 }, new int[] { 1, 2, 3, 4 } }
        };
    }

    @Test(dataProvider = "getMergedArrays")
    public void mergeIter_should_mergeSortedArrays(int[] a, int[] b, int[] expected) {
        Assert.assertTrue(Arrays.equals(MergeSort.mergeIter(a, b), expected));
    }
}
