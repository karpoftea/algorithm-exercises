package il.karpov.algorithm.exercises.cci.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer19StringRotationTest {

    @DataProvider
    public static Object[][] getStrings() {
        return new Object[][]{
                {"waterbottle", "waterbottle", true},
                {"waterbottle", "bottlewater", true},
                {"waterbottle", "erbottlewat", true},
                {"waterbottle", "qrbottlewat", false},
                {"waterbottle", "wwaterwater", false},
        };
    }

    @Test(dataProvider = "getStrings")
    public void isRotation_should_checkIsStringIsRotationOfOriginal(String original, String tested, boolean isRotation) {
        Exer19StringRotation exer = new Exer19StringRotation();
        Assert.assertEquals(exer.isStringRotation(original, tested), isRotation);
    }
}
