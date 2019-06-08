package il.karpov.algorithm.exercises.cci.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer11IsUniqueTest {

    Exer11IsUnique tested = new Exer11IsUnique();

    @DataProvider
    private static Object[][] getStrings() {
        return new Object[][]{
                {null, true},
                {"", true},
                {"a", true},
                {"aa", false},
                {"hello", false},
                {"abcd", true}
        };
    }

    @Test(dataProvider = "getStrings")
    public void isUnique_should_returnTrue_when_noDuplicateCharsInString(String word, boolean expected) {
        Assert.assertEquals(tested.isUnique(word), expected);
    }
}
