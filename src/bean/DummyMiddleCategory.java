package bean;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class DummyMiddleCategory extends BaseBean {

	private String categoryKey;
	
	private String key;

	private String name;

	private String condition1;

	private String condition2;

	public String getCategoryKey() {
		return categoryKey;
	}

	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition1() {
		return condition1;
	}

	public void setCondition1(String condition1) {
		this.condition1 = condition1;
	}

	public String getCondition2() {
		return condition2;
	}

	public void setCondition2(String condition2) {
		this.condition2 = condition2;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		Field[] fields = this.getClass().getDeclaredFields();
	
		Stream.of(fields).forEach(field -> this.setItemPropeties(sb, field));
		
		return sb.toString();
	}
	
}
