package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;

public class PravdaTxtFileTest {
    @Test
    void txtTest() throws IOException {
        String txtFilePath = "./src/test/resources/files/pravda.txt";
        String expectedData = "Network node is build on top of Tendermint, is written in Scala and runs on JVM.";

        String actualData = readTextFromPath(txtFilePath);

        assertThat(actualData, containsString(expectedData));
    }
}
