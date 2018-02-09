package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import exceptions.BadURLException;

public class WikipediaPage {
	
	private String urlString;
	
	private String contents; // likely not the optimal way to store contents of a webpage. 

	public WikipediaPage(String url) {
		
		this.urlString = url;
	}
	
	public boolean readPage() {
		
		try {
			URL urlToRead = formURL();
		} catch (BadURLException e) {
			Logger.logError(e.getMessage());
			return false;
		}
		
		

		
		return true; // TODO...
	}
	
	private URL formURL() throws BadURLException {
		
		URL urlObject = null;
		
		try {
			urlObject = new URL(urlString);
		} catch (MalformedURLException e) {	
			throw new BadURLException(urlString);
		}
		
		return urlObject;
		
	}
	
}
