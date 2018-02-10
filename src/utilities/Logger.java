package utilities;

public class Logger {
	
	
	private static boolean OutputMessages = true;
	
	
	public static void turnOff() {
		OutputMessages = false;
	}
	
	public static void turnOn() {
		OutputMessages = true;
	}
	
	public static boolean isTurnedOn() {
		return OutputMessages;
	}
	
	public static void logError(String message) {
		
		if (OutputMessages)
			System.err.println(message);
	}
	
	public static void logMessage(String message) {
		System.out.println(message);
	}
}
