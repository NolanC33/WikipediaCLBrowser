package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import exceptions.BufferCreationException;

public class WikipediaPage {
	
	// Instance /////////////////////////////////////////////////////////////////
	
	private URL wikiPageURl;
	
	private String firstParagraph; // likely not the optimal way to store contents of a webpage.
	
	private String title;
	
	

	WikipediaPage(URL url) {
		
		this.wikiPageURl = url;
	}
	
	public boolean readPage() {
		
		BufferedReader in = null;
		try {
			in = createBufferedReaderForPage();
		} catch (BufferCreationException e) {
			Logger.logError(e.getMessage());
			return false;
		}
		
		String inputLine;
		
		
		StringBuffer whatWasRead = new StringBuffer();

		
		try {
			
			while((inputLine = in.readLine()) != null) {
				whatWasRead.append(inputLine);
			}
			
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Logger.logMessage(whatWasRead.toString());

		
		return true; // TODO...
	}
	
	private BufferedReader createBufferedReaderForPage() throws BufferCreationException {
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(wikiPageURl.openStream()));
		} catch (MalformedURLException e) {	
			throw new BufferCreationException("The url \"" + "urlString" + "\" is not valid");
		} catch (IOException e) {
			throw new BufferCreationException("An IO Exception Occured");
		}
		
		return in;
		
	}
	
}
