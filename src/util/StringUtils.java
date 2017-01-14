package util;

import java.lang.reflect.Field;

import bean.LastCategory;

public class StringUtils {

	public static void setItemPropeties(StringBuilder sb, Field field, LastCategory lastCategory) {

		field.setAccessible(true);
		sb.append(field.getName());
		sb.append(":");
		
		try {
			sb.append(field.get(lastCategory));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			//何もしない
		}finally {
			sb.append(",");
		}
	}
}
