package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import exceptions.BufferCreationException;

public class WikipediaPage {
	
	private String urlString;
	
	private String contents; // likely not the optimal way to store contents of a webpage. 

	public WikipediaPage(String url) {
		
		this.urlString = url;
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
		
		URL urlObject = null;
		BufferedReader in = null;
		
		try {
			urlObject = new URL(urlString);
			in = new BufferedReader(new InputStreamReader(urlObject.openStream()));
		} catch (MalformedURLException e) {	
			throw new BufferCreationException("The url \"" + "urlString" + "\" is not valid");
		} catch (IOException e) {
			throw new BufferCreationException("An IO Exception Occured");
		}
		
		return in;
		
	}
	
}
