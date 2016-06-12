package sample.logic;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

	public void excecute() {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		ZonedDateTime z1 = ZonedDateTime.now();
		Instant i3 = z1.toInstant();
		ZonedDateTime z3 = i3.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println("pattern1(Asia/Tokyo):" + z3.format(fmt));

		//pattern1と同じ結果になる。
		Date currentDate = new Date();
		Instant now = currentDate.toInstant();
		ZoneId currentZone = ZoneId.systemDefault();
		ZonedDateTime z3_1 = ZonedDateTime.ofInstant(now, currentZone);
		System.out.println("pattern2(" + z3_1.getZone() + "):" + z3_1.format(fmt));
		
		ZonedDateTime z3_2 = i3.atZone(ZoneId.of("Europe/Paris"));
		System.out.println("pattern3(Europe/Paris):" + z3_2.format(fmt));
	}
}
