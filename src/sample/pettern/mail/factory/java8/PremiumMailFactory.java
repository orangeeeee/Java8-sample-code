package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.MailData;
import sample.pettern.factory.bean.ReserveInfo;

public class PremiumMailFactory extends AbstructMailFactory implements MailFactory {
	
	/** mail template id */
	private static String MAIL_TEMPLATE_NAME = "premium.txt";
	
	
	/** メールタイトル */
	private static String TITLE = "プレミアム会員お得情報";
	
	
	@Override
	public MailData create(ReserveInfo reserveInfo) {
		
		MailData data = new MailData();
		data.setToAddress(TO_ADDRESS);
		data.setFromAddress(reserveInfo.getMailAddress());
		data.setTitle(TITLE);
		data.setBody(createBody(reserveInfo));
		
		return data;
	}

	@Override
	public String getBody() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String createBody(ReserveInfo reserveInfo) {
		String template = getTemplate(MAIL_TEMPLATE_NAME);
		//template bin
		System.out.println(template);
		return "create body string";
	}

}
