package il.karpov.algorithm.exercises.cci.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer13URLifyTest {

    @DataProvider
    public static Object[][] getStrings() {
        return new Object[][] {
                {"   ", 1, "%20"},
                {"a man  ", 5, "a%20man"},
                {"a man     ", 6, "a%20man%20"},
                {" a man    ", 6, "%20a%20man"},
        };
    }

    @Test(dataProvider = "getStrings")
    public void urlify_should_replaceSpaceCharWithEncodeSymbol(String actual, int senEndPos, String expected) {
        Exer13URLify exer = new Exer13URLify();

        char[] charArray = actual.toCharArray();
        exer.urlify(charArray, senEndPos);

        Assert.assertEquals(expected, new String(charArray));
    }
}
