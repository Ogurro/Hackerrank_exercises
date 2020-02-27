package learning.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HashTables_checkMagazineTest {

    private String[] magazine;
    private String[] note;
    private boolean expectedResult;

    public HashTables_checkMagazineTest(String[] magazine, String[] note, boolean expectedResult) {
        this.magazine = magazine;
        this.note = note;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inputParameters() {
        return Arrays.asList(new Object[][]{
                {new String[]{"give", "me", "one", "grand", "today", "night"}, new String[]{"give", "one", "grand", "today"}, true},
                {new String[]{"two", "times", "three", "is", "not", "four"}, new String[]{"two", "times", "two", "is", "four"}, false},
                {new String[]{"ive", "got", "a", "lovely", "bunch", "of", "coconuts"}, new String[]{"ive", "got", "some", "coconuts"}, false}
        });
    }

    @Test
    public void checkMagazineTest() {
        assertEquals(expectedResult, HashTables.checkMagazine(magazine, note));
    }

}
