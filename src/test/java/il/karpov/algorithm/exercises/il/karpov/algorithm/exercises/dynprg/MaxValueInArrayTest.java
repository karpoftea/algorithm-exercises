package il.karpov.algorithm.exercises.il.karpov.algorithm.exercises.dynprg;

import il.karpov.algorithm.exercises.dynprg.MaxValueInArray;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class MaxValueInArrayTest {

    @DataProvider
    public static Object[][] getValues() {
        return new Object[][]{
                { new int[]{3, 5, 6, 2, 1, 8}, new Integer[]{3, 6, 8} },
                { new int[]{1, 3, 4, 6}, new Integer[]{3, 6} },
                { new int[]{8, 1, 4, 2, 3, 7, 2}, new Integer[]{8, 4, 7} },
                { new int[]{1, 2}, new Integer[0] }
        };
    }

    @Test(dataProvider = "getValues")
    public void findMaxStolenValue_should_findSequenceOfNotAdjusentValueWithMaxSum(int[] input, Integer[] expected) {
        MaxValueInArray alg = new MaxValueInArray();
        List<Integer> actual = alg.findMaxStolenValue(input);

        if (expected.length == 0) {
            MatcherAssert.assertThat(actual, Is.is(Matchers.empty()));
        } else {
            MatcherAssert.assertThat(actual, Matchers.contains(expected));
        }
    }
}
