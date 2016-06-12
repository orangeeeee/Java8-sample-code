package sample.logic;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTest {

	public void excecute() {

		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");		
		ZonedDateTime z1 = ZonedDateTime.now();
	    Instant i3 = z1.toInstant();
	    ZonedDateTime z3 = i3.atZone(ZoneId.of("Asia/Tokyo"));
	    System.out.println(z3.format(f));
		
	}
}
