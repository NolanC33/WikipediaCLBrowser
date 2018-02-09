package exceptions;

public class BadURLException extends Exception {
	
	public BadURLException(String url) {
		super("The url \"" + "url" + "\" is not valid");
	}
	
}
