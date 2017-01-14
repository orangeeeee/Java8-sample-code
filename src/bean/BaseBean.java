package bean;

import java.lang.reflect.Field;

public abstract class BaseBean {
	
	//Beanの中身を出力
	public abstract String toString();
	
	protected void setItemPropeties(StringBuilder sb, Field field) {

		// TODO 今は、Nestされたクラスについては未対応。
		
		try {
			field.setAccessible(true);
			sb.append(field.getName());
			sb.append(":");
			sb.append(field.get(this));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// 何もしない
		} finally {
			sb.append(",");
		}
	}
	
}
