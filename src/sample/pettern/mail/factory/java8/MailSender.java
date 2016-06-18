package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.MailData;

@FunctionalInterface
public interface MailSender {

	public MailFactory getFactory();
	
	
	default void createSendData(MailData mailData) {
		
		getFactory().create(mailData);
		
		this.run();
	}
	
	/**
	 * これはいらないかな・・・
	 */
	default void run() {
		
	}
	
	/**
	 * 無理やり感がすごいのだが、これは良いのだろうか・・・
	 * @param mailSender
	 */
	public static void handleSendMail(MailSender mailSender, MailData mailData) {

		mailSender.createSendData(mailData);
		mailSender.run();
	}
}
