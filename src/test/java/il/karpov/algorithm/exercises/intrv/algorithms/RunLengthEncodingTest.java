package il.karpov.algorithm.exercises.intrv.algorithms;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunLengthEncodingTest {

    @DataProvider
    public static Object[][] getDataset() {
        return new Object[][] {
            { null, null },
            { "a", "a" },
            { "aa", "aa" },
            { "aaa", "a3" },
            { "aaabbccc", "a3b2c3" },
            { "abbcc", "abbcc" },
            { "aabbcc", "aabbcc" }
        };
    }

    @Test(dataProvider = "getDataset")
    public void encode_should_compressString(String input, String expected) {
        String actual = new RunLengthEncoding().encode(input);
        Assert.assertEquals(actual, expected);
    }
}
