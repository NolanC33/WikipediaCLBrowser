package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import exceptions.PageParseException;

public class WikipediaPage {
	
	// Instance /////////////////////////////////////////////////////////////////
	
	private URL wikiPageURl;
	
	private String firstParagraph; // likely not the optimal way to store contents of a webpage.
	
	private String title;
	

	WikipediaPage(URL url) {
		
		this.wikiPageURl = url;
	}
	
	public boolean parseWikipediaPage() throws PageParseException {
		
		BufferedReader in = null;
		try {
			in = createBufferedReaderForPage();
		} catch (PageParseException e) {
			Logger.logError(e.getMessage());
			return false;
		}
		
		Document thePage = readPageContents(in);
		

		
		return true; // TODO...
	}
	
	private Document readPageContents(BufferedReader pageReader) throws PageParseException {
		
		String inputLine;
		
		
		StringBuffer whatWasRead = new StringBuffer();

		
		try {
			
			while((inputLine = pageReader.readLine()) != null) {
				whatWasRead.append(inputLine);
			}
			
			pageReader.close();

		} catch (IOException e) {
			throw new PageParseException("An IO Exception Occured while reading the file");
		}
		
		
		return Jsoup.parse(whatWasRead.toString());
		
	}
	

	
	private BufferedReader createBufferedReaderForPage() throws PageParseException {
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(wikiPageURl.openStream()));
		} catch (MalformedURLException e) {	
			throw new PageParseException("The url \"" + "urlString" + "\" is not valid");
		} catch (IOException e) {
			throw new PageParseException("An IO Exception Occured while creating the BufferedReader");
		}
		
		return in;
		
	}
	
}
