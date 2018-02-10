package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import exceptions.BadUrlException;
import exceptions.BufferCreationException;

public class WikipediaPage {
	
	
	// Statics /////////////////////////////////////////////////////////////////
	
	public static WikipediaPage CreatePage(String url) throws BadUrlException {
		
		URL u = validateWikipediaURL(url);
		
		return new WikipediaPage(u);
	}
	
	private static URL validateWikipediaURL(String url) throws BadUrlException {
		
		if (url == null) {
			throw new BadUrlException("Argument url is null");
		}
		
		URL u;
		try {
			u = new URL(url);
			u.toURI();
		} catch (MalformedURLException e) {
			throw new BadUrlException("url \"" + url + "\" was malformed");
		} catch (URISyntaxException e) {
			throw new BadUrlException("A valid URL could not be parsed from \"" + url + "\"");
		}
		
		return u;
	}
	
	
	// Instance /////////////////////////////////////////////////////////////////
	
	private URL wikiPageURl;
	
	private String contents; // likely not the optimal way to store contents of a webpage. 

	private WikipediaPage(URL url) {
		
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
