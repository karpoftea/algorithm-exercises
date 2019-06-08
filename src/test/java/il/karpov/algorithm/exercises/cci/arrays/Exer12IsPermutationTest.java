package il.karpov.algorithm.exercises.cci.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer12IsPermutationTest {

    @DataProvider
    public static Object[][] getStrings() {
        return new Object[][]{
                {null, null, false},
                {null, "any", false},
                {"any", null, false},
                {"any", "one", false},
                {"one", "any", false},
                {"any", "any1", false},
                {"any1", "any", false},
                {"any", "anyany", false},
                {"anyany", "any", false},
                {"any", "a", false},
                {"a", "any", false},
                {"yan", "any", true},
                {"yna", "any", true},
                {"nya", "any", true},
                {"nay", "any", true},
        };
    }

    @Test(dataProvider = "getStrings")
    public void isPermutation_should_returnTrue_when_oneStringIsPermOfAnother(String ethalon, String word,
                                                                              boolean expected) {
        Exer12IsPermutation exer = new Exer12IsPermutation();
        Assert.assertEquals(exer.isPermutation(ethalon, word), expected);
    }
}
