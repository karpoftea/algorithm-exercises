package il.karpov.algorithm.exercises.cci.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exer16StringCompressionTest {

    @DataProvider
    public static Object[][] getStrings() {
        return new Object[][] {
                {null, null},
                {"", ""},
                {"a", "a"},
                {"aa", "aa"},
                {"aaa", "a3"},
                {"aaA", "aaA"},
                {"aaab", "aaab"},
                {"aaabb", "a3b2"},
                {"aaabbccccccd", "a3b2c6d1"},
                {"aabcccccaaa", "a2b1c5a3"}
        };
    }

    @Test(dataProvider = "getStrings")
    public void compress_should_makeStringSmaller(String word, String expected) {
        Exer16StringCompression exer = new Exer16StringCompression();
        Assert.assertEquals(exer.compress(word), expected);
    }
}
