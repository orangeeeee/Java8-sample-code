package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.ReserveInfo;

public class mailExcec {

	public static void main(String[] args) {
	
		ReserveInfo mailData = new ReserveInfo();
		mailData.setName("user name");
		mailData.setNumber("user number");
		
		MailSender.handleSendMail(PremiumMailFactory::new, mailData);
	}

}
