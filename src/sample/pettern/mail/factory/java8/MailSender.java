package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.MailData;
import sample.pettern.factory.bean.ReserveInfo;

@FunctionalInterface
public interface MailSender {

	public MailFactory getFactory();
		
	default void sendMail(ReserveInfo reserveInfo) {
		
		MailData mailData = getFactory().create(reserveInfo);
		
		this.send(mailData);
	}
	
	/**
	 * これはいらないかな・・・
	 */
	default void send(MailData mailData) {
		
	}
	
	/**
	 * 無理やり感がすごいのだが、これは良いのだろうか・・・
	 * @param mailSender
	 */
	public static void handleSendMail(MailSender mailSender, ReserveInfo reserveInfo) {

		Runnable task = new Runnable(){
			 
		    @Override
		    public void run(){
		        System.out.println("handleSendMail");
		        mailSender.sendMail(reserveInfo);
		    }
		};
		
		new Thread(task).start();
				
	}
}
