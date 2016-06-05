package bean;

import java.util.List;

public class Category {
	
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
}
