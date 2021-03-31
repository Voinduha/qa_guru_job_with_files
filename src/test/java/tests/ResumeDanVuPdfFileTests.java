package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;

public class ResumeDanVuPdfFileTests {
    @Test
    void pdfTest() throws IOException {
        String pdfFilePath = "./src/test/resources/files/DanVu.pdf";
        String expectedData = "QA Automation engineer";

        PDF pdf = (PDF) getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedData));
    }
}
