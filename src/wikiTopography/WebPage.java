package wikiTopography;

import java.net.MalformedURLException;
import java.net.URL;

public class WebPage {
	
	private String url;
	
	private String contents; // likely not the optimal way to store contents of a webpage. 

	public WebPage(String url) {
		
		this.url = url;
	}
	
	public boolean readPage() {
		
		try {
			URL urlToRead = new URL(url);
		} catch (MalformedURLException e) {
			Logger.logError("The url \"" + url + "\" is not valid");
			return false;
		}
		
		return true; // TODO...
	}
	
}
