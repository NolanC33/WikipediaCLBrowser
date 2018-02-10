package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.BadUrlException;
import exceptions.NotWikipediaURLException;
import utilities.PageManager;

class WikiCLBrowserTests {

	@Test
	void testWikipediaPageFactoryConstructorNull() {
		
		
		boolean exceptionCaught = false;
		
		try {
			PageManager.CreatePage(null);
		} catch (BadUrlException e) {
			exceptionCaught = true;
		} catch (NotWikipediaURLException e) {
			; // not the exception we're looking for. 
		}
		
		assertTrue(exceptionCaught);
	}
	
	@Test
	void testWikipediaPageFactoryConstructorMalformed() {
		boolean exceptionCaught = false;
		
		try {
			PageManager.CreatePage("asdfasdf");
		} catch (BadUrlException e) {
			exceptionCaught = true;
		} catch (NotWikipediaURLException e) {
			; // not the exception we're looking for. 
		}
		
		assertTrue(exceptionCaught);
	}

}