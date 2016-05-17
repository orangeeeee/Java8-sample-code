package test.data;

import java.util.ArrayList;
import java.util.List;

import bean.Category;
import bean.LastCategory;
import bean.MiddleCategory;

public class CreateCategoryDataList {

	public List<Category> create() {

		final String[] keys = { "A", "B", "C", "D", "E" };

		return createCategoryList(keys);
	};

	private List<Category> createCategoryList(String[] keys) {

		final String[] mKeys = { "G", "H", "Q", "Z", "Y", "J" };

		List<Category> tempList = new ArrayList<>();

		for (String key : keys) {

			Category temp = new Category();

			temp.setKey(key);
			temp.setMiddleCategoryList(createMiddle(key, mKeys));
			tempList.add(temp);
		}
		
		return tempList;
	}

	private List<MiddleCategory> createMiddle(String pKey, String[] keys) {

		final String[] mKeys = { "K", "F", "N", "M", "Y", "J" };

		List<MiddleCategory> tempList = new ArrayList<>();

		for (String key : keys) {

			MiddleCategory temp = new MiddleCategory();

			String myKey = pKey + key;
			
			temp.setKey(myKey);
			
			temp.setLastCategoryList(createLast(myKey, mKeys));
			tempList.add(temp);
		}
		
		return tempList;
	}

	private List<LastCategory> createLast(String pKey, String[] keys) {

		List<LastCategory> tempList = new ArrayList<>();

		for (String key : keys) {

			LastCategory temp = new LastCategory();

			temp.setKey(pKey + key);
			tempList.add(temp);
		}

		return tempList;

	}

}
