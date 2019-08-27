package il.karpov.algorithm.exercises.cci.arrays;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;

public class Exer14PalindrPermutsTest {

    private Exer14PalindrPermuts solution = new Exer14PalindrPermuts();

    @DataProvider
    public static Object[][] getTestData() {
        return new Object[][] {
            {"", true},
            {"   ", true},
            {"test", false},
            {"anna", true},
            {"taco cat", true},
            {"кабан упал и лапу набак", true}, // sorry for misspelling
            {"Кабан упал и лапу наба", false}, // case matters!
            {"none", false}
        };
    }

    @Test(dataProvider = "getTestData")
    public void isPalindrPemit_should_testIfStringIsAPalindromePermutation(String word, boolean isPalindrPermut) {
        boolean actualResult = solution.isPalindrPermut(word);
        MatcherAssert.assertThat(actualResult, is(isPalindrPermut));
    }
}
