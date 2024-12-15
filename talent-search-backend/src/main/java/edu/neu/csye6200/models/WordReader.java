package edu.neu.csye6200.models;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

import edu.neu.csye6200.models.interfaces.ScanResume;

/**
 * Implementation of the ScanResume interface for extracting text content from Word documents.
 * Supports both `.docx` (Office Open XML) and `.doc` (binary) Word formats.
 * - Detect the format of the Word file (Office Open XML or binary).
 * - Extract and return the textual content from the Word document.
 * 
 * Dependencies:
 * - Apache POI (for both XWPFDocument and HWPFDocument handling).
 * 
 */
public class WordReader implements ScanResume {
	
	/**
     * Extracts the text content from a Word file (.docx or .doc) located at the given file path.
     * - `.docx`: Office Open XML files using `XWPFDocument`.
     * - `.doc`: Binary Word files using `HWPFDocument`.
     * 
     * @param String fileLocation:  The path to the Word document file.
     * 
     * @return A String containing the extracted text content of the Word document.
     * 
     * @throws IOException If an error occurs while reading or processing the file.
     * 
     */
    @Override
    public String getResumeContent(String fileLocation) throws IOException {
        String resumeContent = "";
        
        try (FileInputStream fis = new FileInputStream(fileLocation)) {
            try {
                XWPFDocument document = new XWPFDocument(fis);
                XWPFWordExtractor extractor = new XWPFWordExtractor(document);
                resumeContent = extractor.getText();
                extractor.close();
                document.close();
            } catch (org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException ole2Exception) {
                fis.getChannel().position(0);
                POIFSFileSystem fs = new POIFSFileSystem(fis);
                HWPFDocument document = new HWPFDocument(fs);
                WordExtractor extractor = new WordExtractor(document);
                resumeContent = extractor.getText();
                extractor.close();
                document.close();
                fs.close();
            }
        }
        
        return resumeContent;
    }
}