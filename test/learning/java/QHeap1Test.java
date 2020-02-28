package learning.java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

@RunWith(Parameterized.class)
public class QHeap1Test {

    private String inputFileLocation;
    private File outputFile;
    private File expectedFile;

    public QHeap1Test(String name) {
        String fileName = "static/files/QHeap1_%s_%s.txt";
        this.inputFileLocation = String.format(fileName, name, "input");
        this.outputFile = new File(String.format(fileName, name, "output"));
        this.expectedFile = new File(String.format(fileName, name, "expected"));
    }

    @Parameterized.Parameters
    public static Collection inputParameters() {
        return Arrays.asList(new Object[][]{
                {"Case1"},
                {"Case2"},
                {"Case3"}
        });
    }

    @Test
    public void QHeap1Test() throws IOException {
        QHeap1.runMe(inputFileLocation);

        assertEquals(Files.lines(expectedFile.toPath()).count(), Files.lines(outputFile.toPath()).count());

        try (Scanner expected = new Scanner(expectedFile);
             Scanner output = new Scanner(outputFile)) {
            while (expected.hasNextLine() && output.hasNextLine()) {
                assertEquals(expected.nextLine(), output.nextLine());
            }
        }
    }
}
