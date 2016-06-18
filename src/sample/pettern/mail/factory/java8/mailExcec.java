package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.MailData;

public class mailExcec {

	public static void main(String[] args) {
	
		MailData mailData = new MailData();
		mailData.setName("user name");
		mailData.setNumber("user number");
		mailData.setTitle("予約完了");
		
		MailSender.handleSendMail(PremiumMailFactory::new, mailData);
	}

}
