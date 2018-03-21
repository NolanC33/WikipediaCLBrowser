package utilities;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Hashtable;

import exceptions.BadUrlException;
import exceptions.NotWikipediaURLException;
import exceptions.PageParseException;

public class PageManager {
	
	private static Hashtable<String, WikipediaPage> PageTable = new Hashtable<String, WikipediaPage>();

	
	public static WikipediaPage CreatePage(String url) throws BadUrlException, NotWikipediaURLException, PageParseException {
		
		URL u = createAndValidateWikipediaURL(url);
		
		return new WikipediaPage(u);
	}

	
	private static URL createAndValidateWikipediaURL(String url) throws BadUrlException, NotWikipediaURLException {
		
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
		
		if (url.startsWith("https://en.wikipedia.org/") == false) {
			throw new NotWikipediaURLException("The url \"" + url + "\" is not a Wikipedia URL");
		}
		
		return u;
	}
}
