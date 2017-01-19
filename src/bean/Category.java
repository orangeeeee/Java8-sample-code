package bean;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Category extends BaseBean {
	
	private String key;

	private String name;
	
	private List<MiddleCategory> middleCategoryList;

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

	public List<MiddleCategory> getMiddleCategoryList() {
		return middleCategoryList;
	}

	public void setMiddleCategoryList(List<MiddleCategory> middleCategoryList) {
		this.middleCategoryList = middleCategoryList;
	}

	/**
	 * デフォルトのcategoryデータを返す。
	 * @return
	 */
	public static Category getDefaultData() {
		
		Category category = new Category();
		category.setKey("KA");
		category.setName("カーボンアンカー");
		category.setMiddleCategoryList(null);
		
		return category;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		Field[] fields = this.getClass().getDeclaredFields();
	
		Stream.of(fields).forEach(field -> this.setItemPropeties(sb, field));
		
		return sb.toString();
	}
}
