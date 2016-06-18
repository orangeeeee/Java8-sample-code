package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.MailData;
import sample.pettern.factory.bean.ReserveInfo;

public interface MailFactory {

	final String TO_ADDRESS = "service@co.jp";
	
	MailData create(ReserveInfo mailData);
	
	String getBody();
	
	String createBody(ReserveInfo reserveInfo);
	
	String getTemplate();
	
}
