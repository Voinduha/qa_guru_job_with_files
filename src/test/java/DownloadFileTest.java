import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadFileTest {

    @Test
    void pravdaDownloadReadMeTest() throws IOException {
        Configuration.downloadsFolder = "downloads";

        open("https://github.com/expload/pravda/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent = FileUtils.readFileToString(downloadedFile, StandardCharsets.UTF_8);

        //assertTrue(fileContent.contains("Pravda is a general purpose blockchain with PoA consensus"));
        assertThat(fileContent, containsString("Pravda is a general purpose blockchain with PoA consensus"));

    }
}
