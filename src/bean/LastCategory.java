package bean;

import java.lang.reflect.Field;
import java.util.Arrays;

import util.StringUtils;

public class LastCategory {
	
	private String key;

	private String name;
	
	private boolean flag1;

	private boolean flag2;
	
	private boolean flag3;

	private String ditail1;

	private String ditail2;

	private String ditail3;

	private String ditail4;

	private String ditail5;

	private String ditail6;

	private String ditail7;

	private String ditail8;

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

	public String getDitail1() {
		return ditail1;
	}

	public void setDitail1(String ditail1) {
		this.ditail1 = ditail1;
	}

	public String getDitail2() {
		return ditail2;
	}

	public void setDitail2(String ditail2) {
		this.ditail2 = ditail2;
	}

	public String getDitail3() {
		return ditail3;
	}

	public void setDitail3(String ditail3) {
		this.ditail3 = ditail3;
	}

	public String getDitail4() {
		return ditail4;
	}

	public void setDitail4(String ditail4) {
		this.ditail4 = ditail4;
	}

	public String getDitail5() {
		return ditail5;
	}

	public void setDitail5(String ditail5) {
		this.ditail5 = ditail5;
	}

	public String getDitail6() {
		return ditail6;
	}

	public void setDitail6(String ditail6) {
		this.ditail6 = ditail6;
	}

	public String getDitail7() {
		return ditail7;
	}

	public void setDitail7(String ditail7) {
		this.ditail7 = ditail7;
	}

	public String getDitail8() {
		return ditail8;
	}

	public void setDitail8(String ditail8) {
		this.ditail8 = ditail8;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		Field[] fields = this.getClass().getDeclaredFields();
	
		Arrays.asList(fields).stream().forEach(field -> StringUtils.setItemPropeties(sb, field, this));
		
		return sb.toString();
	}
}
