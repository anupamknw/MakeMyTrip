package utils;

/**
 * This class is used to write OS related utility functions
 * @author in-anupamp
 *
 */
public class OSUtil {
	private static String OS = null;

	public static String getOsName() {
		if (OS == null) {
			OS = System.getProperty("os.name");
		}
		return OS;
	}

	public static boolean isWindows() {
		return getOsName().startsWith("Windows");
	}

	public static boolean isLinux() {
		return getOsName().startsWith("Linux");
	}
	
	public static boolean isMac()
	{
		return getOsName().startsWith("Mac");
	}
}
