package Utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
	public static String getDateTime()
	{
		DateTimeFormatter DT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
		LocalDateTime current= LocalDateTime.now();
		String a= DT.format(current);
		return a;	
	}
}
