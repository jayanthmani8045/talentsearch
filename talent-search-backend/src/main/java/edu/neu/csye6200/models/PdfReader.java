package edu.neu.csye6200.models;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import edu.neu.csye6200.models.interfaces.ScanResume;

/**
 * Implementation of the ScanResume interface for extracting text content from PDF files.
 * Uses Apache PDFBox for processing and extracting text from PDF documents.
 * - Load and process a PDF file from the given file location.
 * - Extract and return the textual content from the PDF document.
 * 
 * Dependencies:
 * - Apache PDFBox (for text extraction from PDF files).
 * 
 */
public class PdfReader implements ScanResume{
	
	/**
     * Extracts the text content from a PDF file located at the given file path.
     * 
     * @param String fileLocation: The path to the PDF file.
     * 
     * @return A String containing the extracted text content of the PDF document.
     * 
     * @throws IOException If an error occurs while reading or processing the file.
     */
	@Override
	public String getResumeContent(String fileLocation) throws IOException {
		String resumeContent="";
		PDDocument doc = new PDDocument();
		try
		{
		   File file=new File(fileLocation);
		   PDFTextStripper stripper=new PDFTextStripper();
		   doc = Loader.loadPDF(file);
		   resumeContent=stripper.getText(doc);
		}
		finally
		{
		   if( doc != null )
		   {
		      doc.close();
		   }
		}
		return resumeContent;
	}
	
}
