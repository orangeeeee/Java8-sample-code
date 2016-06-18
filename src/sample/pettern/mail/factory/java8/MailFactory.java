package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.MailData;

public interface MailFactory {

	public final String TO_ADDRESS = "service@co.jp";
	
	void create(MailData mailData);
	
	String getBody();
	
}
