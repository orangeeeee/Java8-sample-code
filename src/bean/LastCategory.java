package bean;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class LastCategory extends BaseBean {
	
	private String key;

	private String name;
	
	private boolean flag1;

	private boolean flag2;
	
	private boolean flag3;

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

	public boolean isFlag1() {
		return flag1;
	}

	public void setFlag1(boolean flag1) {
		this.flag1 = flag1;
	}

	public boolean isFlag2() {
		return flag2;
	}

	public void setFlag2(boolean flag2) {
		this.flag2 = flag2;
	}

	public boolean isFlag3() {
		return flag3;
	}

	public void setFlag3(boolean flag3) {
		this.flag3 = flag3;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		Field[] fields = this.getClass().getDeclaredFields();
	
		Stream.of(fields).forEach(field -> this.setItemPropeties(sb, field));
		
		return sb.toString();
	}
}
