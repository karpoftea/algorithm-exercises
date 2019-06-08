package il.karpov.algorithm.exercises.cci.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer15OneAwayTest {

    @DataProvider
    public static Object[][] getStrings() {
        return new Object[][] {
                {"pale", "ple", true},
                {"pales", "pale", true},
                {"pale", "bale", true},
                {"pale", "bake", false}
        };
    }

    @Test(dataProvider = "getStrings")
    public void isOneAway_should_checkIfStringsAreOneEditAway(String one, String two, boolean expected) {
        Exer15OneAway exer = new Exer15OneAway();
        Assert.assertEquals(exer.isOneAway(one, two), expected);
    }
}
