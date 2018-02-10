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
	
	private String contents; // likely not the optimal way to store contents of a webpage. 

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
