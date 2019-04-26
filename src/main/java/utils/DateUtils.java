package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	static LocalDateTime now = LocalDateTime.now();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

	public static String getTodayDate() {
		String formatDateTime = now.plusDays(1).format(formatter);
		return formatDateTime;
	}

	public static String getDateAfter7Days() {
		LocalDateTime date = now.plusDays(7);
		String formatDateTime = date.format(formatter);
		return formatDateTime;
	}
}
