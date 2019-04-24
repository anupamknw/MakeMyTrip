package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	static LocalDateTime now = LocalDateTime.now();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

	public static String getTodayDate() {
		String formatDateTime = now.format(formatter);
		return formatDateTime;
	}

	public static String getDateAfter7Days() {
		LocalDateTime date = now.plusDays(1);
		String formatDateTime = date.format(formatter);
		return formatDateTime;
	}
}
