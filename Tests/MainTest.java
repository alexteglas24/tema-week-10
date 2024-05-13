import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;

public class MainTest {
    @Test
    public void testMain() throws Exception {
        String inputFileName = "input.txt";
        int targetMonth = 1;
        String outputFileName = "output.txt";

        // Prepare input file
        List<String> lines = Arrays.asList("John,Doe,2000-01-01", "Jane,Doe,2000-02-02");
        Files.write(Paths.get(inputFileName), lines);

        // Run the main method
        Main.main(new String[] {inputFileName, String.valueOf(targetMonth), outputFileName});

        // Check the output file
        List<String> outputLines = Files.readAllLines(Paths.get(outputFileName));
        Assertions.assertEquals(1, outputLines.size());
        Assertions.assertEquals("John,Doe", outputLines.get(0));
    }
}