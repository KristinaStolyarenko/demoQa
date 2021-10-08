package com.krissirin;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.LocalFileHeader;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesTests {

    @Test
    void txtTest() throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("test.txt");
        String txt = new String(is.readAllBytes(), "UTF-8");
        assertThat(txt).contains("txt test");
    }

    @Test
    void pdfTest() throws Exception {
        PDF pdf = new PDF(getClass().getClassLoader().getResourceAsStream("test.pdf"));
        assertThat(pdf.creator).contains("Writer");
        assertThat(pdf.numberOfPages).isEqualTo(1);
        assertThat(pdf.text).contains("Dummy");
    }

    @Test
    void xlsTest() throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("test.xlsx");
        XLS xls = new XLS(is);
        assertThat(xls.excel.getNumberOfSheets()).isEqualTo(1);
        assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue()).isEqualTo("KSM9999");
    }

    @Test
    void zipTest() throws Exception {
        String password = "qwerty";
        InputStream is = getClass().getClassLoader().getResourceAsStream("test.zip");
        ZipInputStream zis = new ZipInputStream(is, password.toCharArray());
        LocalFileHeader localFileHeader;

        while ((localFileHeader = zis.getNextEntry()) != null) {
            File extractedFile = new File(localFileHeader.getFileName());
            assertThat(extractedFile.toString()).contains("test.txt");
        }
    }

    @Test
    void docTest() throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("test.docx");
        XWPFDocument doc = new XWPFDocument(is);
        XWPFWordExtractor docExtracted = new XWPFWordExtractor(doc);
        assertThat(docExtracted.getText()).contains("AZVOD219T000000B");
    }
}
