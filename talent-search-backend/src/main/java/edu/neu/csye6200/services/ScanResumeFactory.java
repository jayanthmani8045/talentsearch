package edu.neu.csye6200.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import edu.neu.csye6200.models.Candidate;
import edu.neu.csye6200.models.PdfReader;
import edu.neu.csye6200.models.WordReader;
import edu.neu.csye6200.models.interfaces.ScanResume;

/**
 * Factory class for creating and managing resume readers for Word and PDF file types.
 * This class uses the Singleton pattern to ensure that only one instance of each
 * reader (e.g., WordReader, PdfReader) is created and reused across the application.
 * 
 * - Determine the file type based on the file name or extension.
 * - Lazily initialize and return the appropriate reader instance for the file type.
 * - Ensure thread safety when creating reader instances.
 * 
 */

@Service
public class ScanResumeFactory {
	
	//use volatile keyword, indicating variable's value will be modified by different threads
	//ensure that changes to these readers are always visible to other threads, preventing thread caching issues
	private volatile ScanResume reader_Word;
	private volatile ScanResume reader_PDF;
	
	/**
	 * Returns a reader instance capable of extracting content from the specified file.
	 * 
	 * @param String file: The file name or file path to determine the file type. 
	 * 						It must end with either ".docx", ".doc" or ".pdf".
	 * 
	 * @return A ScanResume instance capable of processing the specified file type.
	 * 
	 * @throws IOException If an error occurs during reader initialization or file handling.
	 */
	public synchronized ScanResume getResumeContent(String file) throws IOException
	{
		if(file.endsWith(".docx") || file.endsWith(".doc"))
		{
			if (reader_Word == null) {
				reader_Word = new WordReader();
	        }
			return reader_Word;
		}
		else if(file.endsWith(".pdf"))
		{
			if (reader_PDF == null) {
				reader_PDF = new PdfReader();
	        }
			return reader_PDF;
		}
		else {
			return null;
		}
	}
	
}
