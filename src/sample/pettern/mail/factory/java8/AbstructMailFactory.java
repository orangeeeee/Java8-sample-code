package sample.pettern.mail.factory.java8;

import sample.pettern.factory.bean.ReserveInfo;

public abstract class AbstructMailFactory {
	
	abstract String getBody();
	
	abstract String createBody(ReserveInfo reserveInfo);
	/**
	 * テンプレートファイルからテンプレートの文字列を取得する。<br>
	 * テンプレートは、メールごとに異なる想定。
	 * @return
	 */
	public String getTemplate(String templateName) {
		
		return "get tempalte File";
	}
}
