package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromFile;

public class DownloadFileTest {

    @Test
    void pravdaDownloadReadMeTest() throws IOException {
        Configuration.downloadsFolder = "downloads";

        open("https://github.com/expload/pravda/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent;
        fileContent = readTextFromFile(downloadedFile);
        assertThat(fileContent, containsString("Pravda is a general purpose blockchain with PoA consensus"));

    }
}
