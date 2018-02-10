package wikiTopography;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.WikipediaPage;

class WikiTopographyTests {

	@Test
	void testWikipediaPageConstructor() {
		WikipediaPage wikiPage = new WikipediaPage("https://www.wikipedia.org/");
		
		assertTrue(wikiPage != null);
	}

}
