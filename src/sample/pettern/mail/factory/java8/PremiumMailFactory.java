package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.MailData;
import sample.pettern.factory.bean.ReserveInfo;

public class PremiumMailFactory extends AbstructMailFactory implements MailFactory {
	
	/** mail template id */
	private static String MAIL_TEMPLATE_NAME = "premium.txt";	
	
	/** メールタイトル */
	private static String TITLE = "プレミアム会員様お得情報";
	
	@Override
	public MailData create(ReserveInfo reserveInfo) {
		
		System.out.println("start create");
		
		MailData data = new MailData();
		data.setToAddress(TO_ADDRESS);
		data.setFromAddress(reserveInfo.getMailAddress());
		data.setTitle(TITLE);
		data.setBody(createBody(reserveInfo));
		
		System.out.println("end create");
		
		return data;
	}
	
	@Override
	public String createBody(ReserveInfo reserveInfo) {
		String template = getTemplate(MAIL_TEMPLATE_NAME);
		//template bin
		System.out.println(template);
		System.out.println("createBody");
		
		return "create body string";
	}

}
