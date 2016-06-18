package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.MailData;
import sample.pettern.factory.bean.ReserveInfo;

public class PremiumMailFactory implements MailFactory {
	
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
	
	/**
	 * テンプレートファイルからテンプレートの文字列を取得する。<br>
	 * テンプレートは、メールごとに異なる想定。
	 * @return
	 */
	@Override
	public String getTemplate() {
		
		return "get Template File";
	}

	@Override
	public String createBody(ReserveInfo reserveInfo) {
		String template = getTemplate();
		//template bin
		System.out.println(template);
		return "create body string";
	}

}
