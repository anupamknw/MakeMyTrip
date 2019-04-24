package base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prac {
	public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after7day=now.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        String formatDateTime = after7day.format(formatter);
        System.out.println(formatDateTime);
	}
}
